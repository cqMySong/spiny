package com.gioov.spiny.user.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.http.BaseResponse;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.BaseStatus;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.api.ViewPageRestController;
import com.gioov.spiny.user.entity.ViewMenuEntity;
import com.gioov.spiny.user.mapper.ViewMenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.User.VIEW_MENU, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViewMenuRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewPageRestController.class);

    private static final String VIEW_MENU = "/API/USER/VIEW_MENU";

    @Autowired
    private ViewMenuMapper viewMenuMapper;

    /**
     * 指定视图菜单分类 id 、角色 id ，分页获取所有视图菜单
     *
     * @param menuCategoryId 视图菜单分类 id
     * @param roleId 角色 id
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/PAGE_ALL_BY_MENU_CATEGORY_id_AND_ROLE_ID')")
    @RequestMapping(value = "/page_all_by_menu_category_id_and_role_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllByMenuCategoryIdAndRoleId(@RequestParam Long menuCategoryId, @RequestParam Long roleId, @RequestParam Integer page, @RequestParam Integer rows) {
        List<ViewMenuEntity> viewMenuEntityList = null;
        Pagination.Result<ViewMenuEntity> paginationResult = new Pagination().new Result<>();

        try {
            viewMenuEntityList = viewMenuMapper.pageAllByMenuCategoryIdAndRoleId(menuCategoryId, roleId, new Pageable(page, rows));
            if (viewMenuEntityList != null) {
                paginationResult.setRows(viewMenuEntityList);
            }
            int count = viewMenuMapper.countAllByMenuCategoryIdAndRoleId(menuCategoryId, roleId);
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 新增视图菜单
     *
     * @param name 视图菜单名
     * @param icon 图标（icon）
     * @param url url
     * @param menuCategoryId 视图菜单分类 id
     * @param sort 排序
     * @param remark 备注
     * @param roleId 角色 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam(required = false) String icon, @RequestParam String url, @RequestParam Long menuCategoryId, @RequestParam Long sort, @RequestParam String remark, @RequestParam Long roleId) {
        ViewMenuEntity viewMenuEntity = null;
        Date date = new Date();
        try {
            viewMenuEntity = new ViewMenuEntity();
            viewMenuEntity.setName(name);
            viewMenuEntity.setIcon(icon);
            viewMenuEntity.setUrl(url);
            viewMenuEntity.setMenuCategoryId(menuCategoryId);
            viewMenuEntity.setSort(sort);
            viewMenuEntity.setRemark(remark);
            viewMenuEntity.setRoleId(roleId);
            viewMenuEntity.setGmtModified(date);
            viewMenuEntity.setGmtCreated(date);
            viewMenuMapper.insertOne(viewMenuEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(viewMenuEntity, HttpStatus.OK);
    }

    /**
     * 保存视图菜单
     *
     * @param id 视图菜单 id
     * @param name 视图菜单名
     * @param icon 图标（icon）
     * @param url url
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam(required = false) String icon, @RequestParam String url, @RequestParam Long sort, @RequestParam String remark) {
        ViewMenuEntity viewMenuEntity = null;
        Date date = new Date();
        try {
            viewMenuEntity = viewMenuMapper.getOne(id);
            viewMenuEntity.setName(name);
            viewMenuEntity.setIcon(icon);
            viewMenuEntity.setUrl(url);
            viewMenuEntity.setSort(sort);
            viewMenuEntity.setRemark(remark);
            viewMenuEntity.setGmtModified(date);
            viewMenuMapper.updateOne(viewMenuEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(viewMenuEntity, HttpStatus.OK);
    }

    /**
     * 指定视图菜单 id ，批量删除视图菜单
     *
     * @param idList 视图菜单 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = viewMenuMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定视图菜单 id ，获取视图菜单信息
     *
     * @param id 视图菜单 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ViewMenuEntity viewMenuEntity = null;
        try {
            viewMenuEntity = viewMenuMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(viewMenuEntity, HttpStatus.OK);
    }


    /**
     * 指定菜单名，模糊搜索获取所有菜单
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_MENU + "/SEARCH_ALL_BY_NAME')")
    @RequestMapping(value = "/search_all_by_name", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> searchAllByName(@RequestParam String q) {
        List<ViewMenuEntity> viewMenuEntityList = null;
        try {
            viewMenuEntityList = viewMenuMapper.searchAllByName(q);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewMenuEntityList, HttpStatus.OK);
    }

}
