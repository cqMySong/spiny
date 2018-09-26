package com.gioov.spiny.user.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.util.StringUtil;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;
import com.gioov.spiny.user.mapper.RoleMapper;
import com.gioov.spiny.user.mapper.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.User.ROLE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleRestController.class);

    private static final String ROLE = "/API/USER/ROLE";

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 分页获取所有角色
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/PAGE_ALL')")
    @RequestMapping(value = "/page_all", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<RoleEntity> roleEntityList = null;
        try {
            roleEntityList = roleMapper.pageAll(new Pageable(page, rows));

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntityList, HttpStatus.OK);
    }


    /**
     * 获取所有角色
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/LIST_ALL')")
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAll() {
        List<RoleEntity> roleEntityList = null;
        try {
            roleEntityList = roleMapper.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntityList, HttpStatus.OK);
    }


    /**
     * 新增角色
     *
     * @param name 角色名
     * @param value 角色值
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam String value, @RequestParam String remark) {
        RoleEntity roleEntity = null;
        Date date = new Date();
        try {
            value = value.toUpperCase();
            roleEntity = roleMapper.getOneByValue(value);
            if (roleEntity != null) {
                throw new BaseResponseException(FailureMessage.ADD_ROLE_VALUE_FAIL);
            }
            roleEntity = new RoleEntity();
            roleEntity.setName(name);
            roleEntity.setValue(value);
            roleEntity.setRemark(remark);
            roleEntity.setGmtModified(date);
            roleEntity.setGmtCreated(date);
            roleMapper.insertOne(roleEntity);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntity, HttpStatus.OK);
    }

    /**
     * 保存角色
     *
     * @param id 角色 id
     * @param name 角色名
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam String value, @RequestParam String remark) {
        RoleEntity roleEntity = null;
        Date date = new Date();
        try {
            value = value.toUpperCase();
            roleEntity = roleMapper.getOne(id);
            roleEntity.setName(name);
            roleEntity.setValue(value);
            roleEntity.setRemark(remark);
            roleEntity.setGmtModified(date);
            roleMapper.updateOne(roleEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntity, HttpStatus.OK);
    }

    /**
     * 指定角色 id ，批量删除角色
     *
     * @param idList 角色 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {

        int result = 0;
        try {

            for (Long id : idList) {
                UserRoleEntity userRoleEntity = userRoleMapper.getOneByRoleId(id);
                if (userRoleEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_ROLE_FAIL_USER_HAS_EXISTED);
                }
            }

            result = roleMapper.deleteAll(idList);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定角色 id ，获取角色信息
     *
     * @param id 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        RoleEntity roleEntity = null;
        try {
            roleEntity = roleMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntity, HttpStatus.OK);
    }

    /**
     * 指定用户 id ，获取用户角色
     *
     * @param userId 用户 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + ROLE + "/ONE')")
    @RequestMapping(value = "/list_all_by_user_id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllByUserId(@PathVariable Long userId) {
        List<RoleEntity> roleEntityList = new ArrayList<>();
        try {

            List<UserRoleEntity> userRoleEntityList = userRoleMapper.listAllByUserId(userId);
            if (userRoleEntityList != null && !userRoleEntityList.isEmpty()) {
                for (UserRoleEntity userRoleEntity : userRoleEntityList) {
                    RoleEntity roleEntity = roleMapper.getOne(userRoleEntity.getRoleId());
                    roleEntityList.add(roleEntity);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleEntityList, HttpStatus.OK);
    }

}
