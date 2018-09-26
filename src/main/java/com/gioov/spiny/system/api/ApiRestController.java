package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.ApiEntity;
import com.gioov.spiny.system.mapper.ApiMapper;
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
@RequestMapping(value = Api.System.API, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRestController.class);

    private static final String API = "/API/SYSTEM/API";

    @Autowired
    private ApiMapper apiMapper;

    /**
     * 指定 API 分类 id ，分页获取所有 API
     *
     * @param page
     * @param rows
     * @param apiCategoryId
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API + "/PAGE_ALL_BY_API_CATEGORY_ID')")
    @RequestMapping(value = "/page_all_by_api_category_id/{apiCategoryId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllByApiCategoryId(@RequestParam Integer page, @RequestParam Integer rows, @PathVariable Long apiCategoryId) {
        List<ApiEntity> apiEntityList = null;
        Pagination.Result<ApiEntity> paginationResult = new Pagination().new Result<>();

        try {
            apiEntityList = apiMapper.pageAllByApiCategoryId(apiCategoryId, new Pageable(page, rows));
            if (apiEntityList != null) {
                paginationResult.setRows(apiEntityList);
            }
            int count = apiMapper.countAllByApiCategoryId(apiCategoryId);
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 新增 API
     *
     * @param name
     * @param url
     * @param authority
     * @param apiCategoryId
     * @param sort
     * @param remark
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam String url, @RequestParam String authority, @RequestParam Long apiCategoryId, @RequestParam Long sort, @RequestParam String remark) {
        ApiEntity apiEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();
            if (apiMapper.getOneByAuthority(authority) != null) {
                throw new BaseResponseException(FailureMessage.ADD_API_AUTHORITY_FAIL);
            }
            apiEntity = new ApiEntity();
            apiEntity.setName(name);
            apiEntity.setUrl(url);
            apiEntity.setAuthority(authority);
            apiEntity.setApiCategoryId(apiCategoryId);
            apiEntity.setSort(sort);
            apiEntity.setRemark(remark);
            apiEntity.setGmtModified(date);
            apiEntity.setGmtCreated(date);
            apiMapper.insertOne(apiEntity);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiEntity, HttpStatus.OK);
    }

    /**
     * 保存 API
     *
     * @param id
     * @param name
     * @param url
     * @param sort
     * @param remark
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam String url, @RequestParam String authority, @RequestParam Long sort, @RequestParam String remark) {
        ApiEntity apiEntity = null;
        Date date = new Date();
        try {
            authority = authority.toUpperCase();
            apiEntity = apiMapper.getOne(id);
            apiEntity.setName(name);
            apiEntity.setUrl(url);
            apiEntity.setAuthority(authority);
            apiEntity.setSort(sort);
            apiEntity.setRemark(remark);
            apiEntity.setGmtModified(date);
            apiMapper.updateOne(apiEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiEntity, HttpStatus.OK);
    }

    /**
     * 指定 API id ，批量删除 API
     *
     * @param idList
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = apiMapper.deleteAll(idList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    /**
     * 指定 API id ， 获取 API 信息
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ApiEntity apiEntity = null;
        try {
            apiEntity = apiMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiEntity, HttpStatus.OK);
    }

}
