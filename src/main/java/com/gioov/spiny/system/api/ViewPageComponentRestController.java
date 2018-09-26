package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.ViewPageComponentEntity;
import com.gioov.spiny.system.mapper.ViewPageComponentMapper;
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
@RequestMapping(value = Api.System.VIEW_PAGE_COMPONENT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViewPageComponentRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewPageComponentRestController.class);

    private static final String VIEW_PAGE_COMPONENT = "/API/SYSTEM/VIEW_PAGE_COMPONENT";

    @Autowired
    private ViewPageComponentMapper viewPageComponentMapper;

    /**
     * 分页获取所有视图页面组件
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT + "/PAGE_ALL_BY_PAGE_ID')")
    @RequestMapping(value = "/page_all_by_page_id/{pageId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllByPageId(@PathVariable Long pageId, @RequestParam Integer page, @RequestParam Integer rows) {
        List<ViewPageComponentEntity> viewPageComponentEntityList = null;
        Pagination.Result<ViewPageComponentEntity> paginationResult = new Pagination().new Result<>();
        try {

            viewPageComponentEntityList = viewPageComponentMapper.pageAllByPageId(pageId, new Pageable(page, rows));

            if (viewPageComponentEntityList != null) {
                paginationResult.setRows(viewPageComponentEntityList);
            }
            int count = viewPageComponentMapper.countAllByPageId(pageId);
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 新增视图页面组件
     *
     * @param pageComponentType 视图页面组件类型
     * @param name 视图页面组件名
     * @param authority 权限（authority）
     * @param pageId 视图页面 id
     * @param sort 排序
     * @param remark 备注
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam Long pageComponentType, @RequestParam String name, @RequestParam String authority, @RequestParam Long pageId, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageComponentEntity viewPageComponentEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();

            if (viewPageComponentMapper.getOneByAuthority(authority) != null) {
                throw new BaseResponseException(FailureMessage.ADD_API_AUTHORITY_FAIL);
            }

            viewPageComponentEntity = new ViewPageComponentEntity();
            viewPageComponentEntity.setPageComponentType(pageComponentType);
            viewPageComponentEntity.setName(name);
            viewPageComponentEntity.setAuthority(authority);
            viewPageComponentEntity.setPageId(pageId);
            viewPageComponentEntity.setSort(sort);
            viewPageComponentEntity.setRemark(remark);
            viewPageComponentEntity.setGmtModified(date);
            viewPageComponentEntity.setGmtCreated(date);
            viewPageComponentMapper.insertOne(viewPageComponentEntity);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageComponentEntity, HttpStatus.OK);
    }

    /**
     * 保存视图页面组件
     *
     * @param id 视图页面组件 id
     * @param pageComponentType 视图页面组件类型
     * @param name 视图页面组件名
     * @param authority 权限（authority）
     * @param sort 排序
     * @param remark 备注
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam Long pageComponentType, @RequestParam String name, @RequestParam String authority, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageComponentEntity viewPageComponentEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();
            viewPageComponentEntity = viewPageComponentMapper.getOne(id);
            viewPageComponentEntity.setPageComponentType(pageComponentType);
            viewPageComponentEntity.setName(name);
            viewPageComponentEntity.setAuthority(authority);
            viewPageComponentEntity.setSort(sort);
            viewPageComponentEntity.setRemark(remark);
            viewPageComponentEntity.setGmtModified(date);
            viewPageComponentMapper.updateOne(viewPageComponentEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageComponentEntity, HttpStatus.OK);
    }


    /**
     * 指定视图页面组件 id ，批量删除视图页面组件
     *
     * @param idList 视图页面组件 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = viewPageComponentMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定视图组件 id ，获取视图组件信息
     *
     * @param id 视图页面组件 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_COMPONENT + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ViewPageComponentEntity viewPageComponentEntity = null;
        try {
            viewPageComponentEntity = viewPageComponentMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageComponentEntity, HttpStatus.OK);
    }

}
