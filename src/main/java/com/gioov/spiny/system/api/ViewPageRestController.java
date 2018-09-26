package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.ViewPageEntity;
import com.gioov.spiny.system.mapper.ViewPageMapper;
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
@RequestMapping(value = Api.System.VIEW_PAGE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViewPageRestController {

    private static final String VIEW_PAGE = "/API/SYSTEM/VIEW_PAGE";

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewPageRestController.class);

    @Autowired
    private ViewPageMapper viewPageMapper;

    /**
     * 指定父级视图页面分类 id ，获取所有视图页面
     *
     * @param page 页
     * @param rows 每页显示数量
     * @param pageCategoryId 视图页面分类
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE + "/PAGE_ALL_BY_PAGE_CATEGORY_ID')")
    @RequestMapping(value = "/page_all_by_page_category_id/{pageCategoryId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllByPageCategoryId(@RequestParam Integer page, @RequestParam Integer rows, @PathVariable Long pageCategoryId) {
        List<ViewPageEntity> viewPageEntityList = null;
        Pagination.Result<ViewPageEntity> paginationResult = new Pagination().new Result<>();

        try {
            viewPageEntityList = viewPageMapper.pageAllByPageCategoryId(pageCategoryId, new Pageable(page, rows));
            if (viewPageEntityList != null) {
                paginationResult.setRows(viewPageEntityList);
            }
            int count = viewPageMapper.countAllByPageCategoryId(pageCategoryId);
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 新增视图页面
     *
     * @param name 视图页面名
     * @param url url
     * @param authority 权限（authority）
     * @param pageCategoryId 视图页面分类 id
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam String url, @RequestParam String authority, @RequestParam Long pageCategoryId, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageEntity viewPageEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();
            viewPageEntity = viewPageMapper.getOneByAuthority(authority);
            if (viewPageEntity != null) {
                throw new BaseResponseException(FailureMessage.ADD_VIEW_PAGE_AUTHORITY_FAIL);
            }
            viewPageEntity = new ViewPageEntity();
            viewPageEntity.setName(name);
            viewPageEntity.setUrl(url);
            viewPageEntity.setAuthority(authority);
            viewPageEntity.setPageCategoryId(pageCategoryId);
            viewPageEntity.setSort(sort);
            viewPageEntity.setRemark(remark);
            viewPageEntity.setGmtModified(date);
            viewPageEntity.setGmtCreated(date);
            viewPageMapper.insertOne(viewPageEntity);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageEntity, HttpStatus.OK);
    }

    /**
     * 保存视图页面
     *
     * @param id 视图页面 id
     * @param name 视图页面名
     * @param url url
     * @param authority 权限（authority）
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam String url, @RequestParam String authority, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageEntity viewPageEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();
            viewPageEntity = viewPageMapper.getOne(id);
            viewPageEntity.setName(name);
            viewPageEntity.setUrl(url);
            viewPageEntity.setAuthority(authority);
            viewPageEntity.setSort(sort);
            viewPageEntity.setRemark(remark);
            viewPageEntity.setGmtModified(date);
            viewPageMapper.updateOne(viewPageEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageEntity, HttpStatus.OK);
    }

    /**
     * 指定视图页面 id ，批量删除视图页面
     *
     * @param idList 视图页面 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = viewPageMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定视图页面 id ，获取视图页面信息
     *
     * @param id 视图页面 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ViewPageEntity viewPageEntity = null;
        try {
            viewPageEntity = viewPageMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageEntity, HttpStatus.OK);
    }

}
