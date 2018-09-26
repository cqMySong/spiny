package com.gioov.spiny.user.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.service.ViewMenuCategoryService;
import com.gioov.spiny.system.service.ViewMenuService;
import com.gioov.spiny.user.entity.ViewMenuCategoryEntity;
import com.gioov.spiny.user.entity.ViewMenuEntity;
import com.gioov.spiny.user.mapper.ViewMenuCategoryMapper;
import com.gioov.spiny.user.mapper.ViewMenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.User.VIEW_MENU_CATEGORY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViewMenuCategoryRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewMenuCategoryRestController.class);

    private static final String VIEW_MENU_CATEGORY = "/API/USER/VIEW_MENU_CATEGORY";

    @Autowired
    private ViewMenuCategoryMapper viewMenuCategoryMapper;

    @Autowired
    private ViewMenuMapper viewMenuMapper;

    @Autowired
    private ViewMenuCategoryService viewMenuCategoryService;

    @Autowired
    private ViewMenuService viewMenuService;

    /**
     * 指定角色 id ，分页获取所有父级视图菜单分类
     *
     * @param roleId 角色 id
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/PAGE_ALL_PARENT_BY_ROLE_ID')")
    @RequestMapping(value = "/page_all_parent_by_role_id/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllParent(@PathVariable Long roleId, @RequestParam Integer page, @RequestParam Integer rows) {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        Pagination.Result<ViewMenuCategoryEntity> paginationResult = new Pagination().new Result<>();

        try {
            viewMenuCategoryEntityList = viewMenuCategoryMapper.pageAllByParentIdIsNullAndRoleId(roleId, new Pageable(page, rows));
            if (viewMenuCategoryEntityList != null) {
                paginationResult.setRows(viewMenuCategoryEntityList);
            }
            int count = viewMenuCategoryMapper.countAllByParentIdIsNullAndRoleId(roleId);
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 指定父级视图菜单分类 id 、角色 id ，获取所有视图菜单分类
     *
     * @param roleId 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL_BY_PARENT_ID_AND_ROLE_ID')")
    @RequestMapping(value = "/list_all_by_parent_id_and_role_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllByParentIdAndRoleId(@RequestParam Long parentId, @RequestParam Long roleId) {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;

        try {
            viewMenuCategoryEntityList = viewMenuCategoryMapper.listAllByParentIdAndRoleId(parentId, roleId);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }

    /**
     * 新增视图菜单分类
     *
     * @param name 视图菜单分类名
     * @param parentId 视图菜单分类父级 id
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam(required = false) String icon, @RequestParam(required = false) Long parentId, @RequestParam Long sort, @RequestParam String remark, @RequestParam Long roleId) {
        ViewMenuCategoryEntity viewMenuCategoryEntity = null;
        Date date = new Date();
        try {
            viewMenuCategoryEntity = new ViewMenuCategoryEntity();
            viewMenuCategoryEntity.setName(name);
            viewMenuCategoryEntity.setIcon(icon);
            viewMenuCategoryEntity.setParentId(parentId);
            viewMenuCategoryEntity.setSort(sort);
            viewMenuCategoryEntity.setRemark(remark);
            viewMenuCategoryEntity.setRoleId(roleId);
            viewMenuCategoryEntity.setGmtModified(date);
            viewMenuCategoryEntity.setGmtCreated(date);
            viewMenuCategoryMapper.insertOne(viewMenuCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntity, HttpStatus.OK);
    }

    /**
     * 保存视图菜单分类
     *
     * @param id 视图菜单分类 id
     * @param name 视图菜单分类名
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam(required = false) String icon, @RequestParam Long sort, @RequestParam String remark) {
        ViewMenuCategoryEntity viewMenuCategoryEntity = null;
        Date date = new Date();
        try {
            viewMenuCategoryEntity = viewMenuCategoryMapper.getOne(id);
            viewMenuCategoryEntity.setName(name);
            viewMenuCategoryEntity.setIcon(icon);
            viewMenuCategoryEntity.setSort(sort);
            viewMenuCategoryEntity.setRemark(remark);
            viewMenuCategoryEntity.setGmtModified(date);
            viewMenuCategoryMapper.updateOne(viewMenuCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntity, HttpStatus.OK);
    }

    /**
     * 指定视图菜单分类 id ，批量删除视图菜单分类
     *
     * @param idList 视图菜单分类 id list
     * @param roleId 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList, @RequestParam Long roleId) {

        int result = 0;
        try {

            for (Long id : idList) {
                ViewMenuCategoryEntity viewMenuCategoryEntity = viewMenuCategoryMapper.getOneByParentIdAndRoleId(id, roleId);
                if (viewMenuCategoryEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_VIEW_MENU_CATEGORY_FAIL1);
                }
                ViewMenuEntity viewMenuEntity = viewMenuMapper.getOneByMenuCategoryIdAndRoleId(id, roleId);
                if (viewMenuEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_VIEW_MENU_CATEGORY_FAIL2);
                }
            }

            result = viewMenuCategoryMapper.deleteAll(idList);


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
     * 指定视图菜单分类 id ，获取视图菜单分类信息
     *
     * @param id 视图菜单分类 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ViewMenuCategoryEntity viewMenuCategoryEntity = null;
        try {
            viewMenuCategoryEntity = viewMenuCategoryMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntity, HttpStatus.OK);
    }


    /**
     * 指定角色 id ，获取所有父级视图菜单分类
     *
     * @param roleId 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL_PARENT_BY_ROLE_ID')")
    @RequestMapping(value = "/list_all_parent_by_role_id/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllParentByRoleId(@PathVariable Long roleId) {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryMapper.listAllByParentIdIsNullAndRoleId(roleId);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }

    /**
     * 指定用户 id ，获取所有父级视图菜单分类
     *
     * @param userId 用户 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL_PARENT_BY_USER_ID')")
    @RequestMapping(value = "/list_all_parent_by_user_id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllParentByUserId(HttpServletResponse httpServletResponse, @PathVariable Long userId) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryService.listAllParentByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(httpStatus), httpStatus);
        }

        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }

    /**
     * 指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类
     *
     * @param userId 用户 id
     * @param parentId 视图菜单分类父级 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL_CHILD_BY_PARENT_ID_AND_USER_ID')")
    @RequestMapping(value = "/list_all_child_by_parent_id_and_user_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllChildByParentIdAndUserId(@RequestParam Long parentId, @RequestParam Long userId) {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryService.listAllChildByParentIdAndUserId(parentId, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }


    /**
     * 指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类和视图菜单
     *
     * @param userId 用户 id
     * @param parentId 视图菜单分类父级 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL_CHILD_VIEW_MENU_CATEGORY_AND_VIEW_MENU_BY_PARENT_ID_AND_USER_ID')")
    @RequestMapping(value = "/list_all_child_view_menu_category_and_view_menu_by_parent_id_and_user_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllChildViewMenuCategoryAndViewMenuByParentIdAndUserId(@RequestParam Long parentId, @RequestParam Long userId) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryService.listAllChildByParentIdAndUserId(parentId, userId);
            if (viewMenuCategoryEntityList != null) {

                for (ViewMenuCategoryEntity viewMenuCategoryEntity : viewMenuCategoryEntityList) {
                    Map<String, Object> map = new HashMap<>(3);
                    map.put("id", viewMenuCategoryEntity.getId());
                    map.put("name", viewMenuCategoryEntity.getName());
                    map.put("icon", viewMenuCategoryEntity.getIcon());
                    mapList.add(map);
                }

                List<ViewMenuEntity> viewMenuEntityList = null;
                viewMenuEntityList = viewMenuService.listAllByUserIdAndMenuCategoryId(userId, parentId);

                if (viewMenuEntityList != null) {

                    for (ViewMenuEntity viewMenuEntity : viewMenuEntityList) {
                        Map<String, Object> map = new HashMap<>(4);
                        map.put("id", viewMenuEntity.getId());
                        map.put("name", viewMenuEntity.getName());
                        map.put("icon", viewMenuEntity.getIcon());
                        map.put("url", viewMenuEntity.getUrl());
                        mapList.add(map);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mapList, HttpStatus.OK);
    }


    /**
     * 获取所有菜单分类
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/LIST_ALL')")
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAll() {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryMapper.listAll();

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }


    /**
     * 指定菜单分类名，模糊搜索获取所有菜单分类
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU_CATEGORY + "/SEARCH_ALL_BY_NAME')")
    @RequestMapping(value = "/search_all_by_name", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> searchAllByName(@RequestParam String q) {
        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;
        try {
            viewMenuCategoryEntityList = viewMenuCategoryMapper.searchAllByName(q);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuCategoryEntityList, HttpStatus.OK);
    }


}
