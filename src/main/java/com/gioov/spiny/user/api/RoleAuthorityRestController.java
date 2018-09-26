package com.gioov.spiny.user.api;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.system.entity.*;
import com.gioov.spiny.system.mapper.*;
import com.gioov.spiny.user.entity.RoleAuthorityEntity;
import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.mapper.RoleAuthorityMapper;
import com.gioov.spiny.user.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.User.ROLE_AUTHORITY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleAuthorityRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleAuthorityRestController.class);

    private static final String ROLE_AUTHORITY = "/API/USER/ROLE_AUTHORITY";

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private ViewPageMapper viewPageMapper;

    @Autowired
    private ViewPageComponentMapper viewPageComponentMapper;

    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private ViewPageApiMapper viewPageApiMapper;

    @Autowired
    private ViewPageComponentApiMapper viewPageComponentApiMapper;

    /**
     * 指定角色 id、API 权限（authority），批量授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/GRANT_ALL_BY_ROLE_ID_AND_API_AUTHORITY_LIST')")
    @RequestMapping(value = "/grant_all_by_role_id_and_api_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> grantAllByRoleIdAndApiAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();

        try {

            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    apiAuthorityList.add(authority);
                }
            }

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : apiAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity == null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部写入数据库
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.insertAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);

    }

    /**
     * 指定角色 id、API 权限（authority），批量撤销授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/REVOKE_ALL_BY_ROLE_ID_AND_API_AUTHORITY_LIST')")
    @RequestMapping(value = "/revoke_all_by_role_id_and_api_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> revokeAllByRoleIdAndApiAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();
        try {

            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    apiAuthorityList.add(authority);
                }
            }

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : apiAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity != null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部删除
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.deleteAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);

    }


    /**
     * 指定角色 id、视图页面权限（authority），批量授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/GRANT_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST')")
    @RequestMapping(value = "/grant_all_by_role_id_and_page_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> grantAllByRoleIdAndPageAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // 视图页面 authority
        List<String> pageAuthorityList = new ArrayList<>();

        // 视图页面组件关联的 API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();

        try {

            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    pageAuthorityList.add(authority);

                    ViewPageEntity viewPageEntity = viewPageMapper.getOneByAuthority(authority);
                    if (viewPageEntity != null) {
                        List<ViewPageApiEntity> viewPageApiEntityList = viewPageApiMapper.listAllByPageId(viewPageEntity.getId());
                        if (viewPageApiEntityList != null && !viewPageApiEntityList.isEmpty()) {

                            for (ViewPageApiEntity viewPageApiEntity : viewPageApiEntityList) {
                                ApiEntity apiEntity = apiMapper.getOne(viewPageApiEntity.getApiId());
                                if (apiEntity != null) {
                                    apiAuthorityList.add(apiEntity.getAuthority());
                                }
                            }
                        }
                    }
                }
            }

            // 视图页面关联的 API authority 全部放入 pageAuthorityList
            pageAuthorityList.addAll(apiAuthorityList);

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : pageAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity == null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部写入数据库
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.insertAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);

    }

    /**
     * 指定角色 id、视图页面权限（authority），批量撤销授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST')")
    @RequestMapping(value = "/revoke_all_by_role_id_and_page_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> revokeAllByRoleIdAndPageAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // 视图页面 authority
        List<String> pageAuthorityList = new ArrayList<>();

        // 视图页面组件关联的 API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();
        try {

            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    pageAuthorityList.add(authority);

                    ViewPageEntity viewPageEntity = viewPageMapper.getOneByAuthority(authority);
                    if (viewPageEntity != null) {
                        List<ViewPageApiEntity> viewPageApiEntityList = viewPageApiMapper.listAllByPageId(viewPageEntity.getId());
                        if (viewPageApiEntityList != null && !viewPageApiEntityList.isEmpty()) {

                            for (ViewPageApiEntity viewPageApiEntity : viewPageApiEntityList) {
                                ApiEntity apiEntity = apiMapper.getOne(viewPageApiEntity.getApiId());
                                if (apiEntity != null) {
                                    apiAuthorityList.add(apiEntity.getAuthority());
                                }
                            }

                        }

                    }

                }
            }

            // 视图页面组件关联的 API authority 全部放入 pageAuthorityList
            pageAuthorityList.addAll(apiAuthorityList);

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : pageAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity != null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部删除
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.deleteAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);

    }

    /**
     * 指定角色 id、视图页面组件权限（authority），批量授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/GRANT_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST')")
    @RequestMapping(value = "/grant_all_by_role_id_and_page_component_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> grantAllByRoleIdAndPageComponentAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // 视图页面组件 authority
        List<String> pageComponentAuthorityList = new ArrayList<>();

        // 视图页面组件关联的 API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();

        try {
            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    pageComponentAuthorityList.add(authority);

                    ViewPageComponentEntity viewPageComponentEntity = viewPageComponentMapper.getOneByAuthority(authority);
                    if (viewPageComponentEntity != null) {
                        List<ViewPageComponentApiEntity> viewPageComponentApiEntityList = viewPageComponentApiMapper.listAllByPageComponentId(viewPageComponentEntity.getId());
                        if (viewPageComponentApiEntityList != null && !viewPageComponentApiEntityList.isEmpty()) {

                            for (ViewPageComponentApiEntity viewPageApiEntity : viewPageComponentApiEntityList) {
                                ApiEntity apiEntity = apiMapper.getOne(viewPageApiEntity.getApiId());
                                if (apiEntity != null) {
                                    apiAuthorityList.add(apiEntity.getAuthority());
                                }
                            }

                        }

                    }

                }
            }

            // 视图页面组件关联的 API authority 全部放入 pageComponentAuthorityList
            pageComponentAuthorityList.addAll(apiAuthorityList);

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : pageComponentAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity == null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部写入数据库
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.insertAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);
    }

    /**
     * 指定角色 id、视图页面组件权限（authority），批量撤销授权
     *
     * @param roleId 角色 id
     * @param authorityList 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST')")
    @RequestMapping(value = "/revoke_all_by_role_id_and_page_component_authority_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> revokeAllByRoleIdAndPageComponentAuthorityList(@RequestParam Long roleId, @RequestParam("authorityList[]") List<String> authorityList) {

        // 视图页面组件 authority
        List<String> pageComponentAuthorityList = new ArrayList<>();

        // 视图页面组件关联的 API authority
        List<String> apiAuthorityList = new ArrayList<>();

        // 最终被添加的 authority
        List<String> authorityList3 = new ArrayList<>();
        try {

            for (String authority : authorityList) {
                if (!"".equals(authority.trim())) {
                    pageComponentAuthorityList.add(authority);

                    ViewPageComponentEntity viewPageComponentEntity = viewPageComponentMapper.getOneByAuthority(authority);
                    if (viewPageComponentEntity != null) {
                        List<ViewPageComponentApiEntity> viewPageComponentApiEntityList = viewPageComponentApiMapper.listAllByPageComponentId(viewPageComponentEntity.getId());
                        if (viewPageComponentApiEntityList != null && !viewPageComponentApiEntityList.isEmpty()) {

                            for (ViewPageComponentApiEntity viewPageApiEntity : viewPageComponentApiEntityList) {
                                ApiEntity apiEntity = apiMapper.getOne(viewPageApiEntity.getApiId());
                                if (apiEntity != null) {
                                    apiAuthorityList.add(apiEntity.getAuthority());
                                }
                            }

                        }

                    }

                }
            }

            // 视图页面组件关联的 API authority 全部放入 pageComponentAuthorityList
            pageComponentAuthorityList.addAll(apiAuthorityList);

            RoleAuthorityEntity roleAuthorityEntity = null;
            for (String a : pageComponentAuthorityList) {
                roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, a);
                if (roleAuthorityEntity != null) {
                    authorityList3.add(a);
                }
            }

            // authority 全部删除
            if (!authorityList3.isEmpty()) {
                roleAuthorityMapper.deleteAllByRoleIdAndAuthorityList(roleId, authorityList3);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authorityList3, HttpStatus.OK);
    }

    /**
     * 指定角色权限 id ，获取角色权限信息
     *
     * @param id 角色权限 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        RoleAuthorityEntity roleAuthorityEntity = null;
        try {
            roleAuthorityEntity = roleAuthorityMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleAuthorityEntity, HttpStatus.OK);
    }

    /**
     * 指定角色 id、权限（authority）判断是否已授权
     *
     * @param roleId 角色 id
     * @param authority 权限（authority） list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE_AUTHORITY + "/IS_GRANTED_BY_ROLE_ID_AND_AUTHORITY')")
    @RequestMapping(value = "/is_granted_by_role_id_and_authority", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> isGrantedByRoleIdAndAuthority(@RequestParam Long roleId, @RequestParam String authority) {
        Map<String, Object> data = new HashMap<>(1);
        data.put("isGranted", false);

        try {
            RoleAuthorityEntity roleAuthorityEntity = roleAuthorityMapper.getOneByRoleIdAndAuthority(roleId, authority);
            if (roleAuthorityEntity != null) {
                data.put("isGranted", true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


}
