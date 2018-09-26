package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.annotation.operationlog.OperationLog;
import com.gioov.spiny.common.annotation.operationlog.OperationLogTypeEnum;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.ApiCategoryEntity;
import com.gioov.spiny.system.entity.ApiEntity;
import com.gioov.spiny.system.mapper.ApiCategoryMapper;
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
@RequestMapping(value = Api.System.API_CATEGORY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiCategoryRestController {

    private static final String API_CATEGORY = "/API/SYSTEM/API_CATEGORY";

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCategoryRestController.class);

    @Autowired
    private ApiCategoryMapper apiCategoryMapper;

    @Autowired
    private ApiMapper apiMapper;

    /**
     * 分页获取所有父级 API 分类
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @OperationLog(value = "分页获取所有父级 API 分类", type = OperationLogTypeEnum.API)
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/PAGE_ALL_PARENT')")
    @RequestMapping(value = "/page_all_parent", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllParent(@RequestParam Integer page, @RequestParam Integer rows) {
        List<ApiCategoryEntity> apiCategoryEntityList = null;
        Pagination.Result<ApiCategoryEntity> paginationResult = new Pagination().new Result<>();

        try {
            apiCategoryEntityList = apiCategoryMapper.pageAllByParentIdIsNull(new Pageable(page, rows));
            if (apiCategoryEntityList != null) {
                paginationResult.setRows(apiCategoryEntityList);
            }
            int count = apiCategoryMapper.countAllByParentIdIsNull();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 指定父级 API 分类 id ，获取所有 API 分类
     *
     * @param parentId API 分类父级 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/LIST_ALL_BY_PARENT_ID')")
    @RequestMapping(value = "/list_all_by_parent_id/{parentId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllByParentId(@PathVariable Long parentId) {
        List<ApiCategoryEntity> apiCategoryEntityList = null;
        try {
            apiCategoryEntityList = apiCategoryMapper.listAllByParentId(parentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiCategoryEntityList, HttpStatus.OK);
    }

    /**
     * 新增 API 分类
     *
     * @param name API 分类名
     * @param parentId API 分类 父级 id
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam(required = false) Long parentId, @RequestParam Long sort, @RequestParam String remark) {
        ApiCategoryEntity apiCategoryEntity = null;
        Date date = new Date();
        try {
            apiCategoryEntity = new ApiCategoryEntity();
            apiCategoryEntity.setName(name);
            if (parentId != null) {
                apiCategoryEntity.setParentId(parentId);
            }
            apiCategoryEntity.setSort(sort);
            apiCategoryEntity.setRemark(remark);
            apiCategoryEntity.setGmtModified(date);
            apiCategoryEntity.setGmtCreated(date);
            apiCategoryMapper.insertOne(apiCategoryEntity);
//            Integer i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiCategoryEntity, HttpStatus.NO_CONTENT);
    }

    /**
     * 保存 API 分类
     *
     * @param id API 分类 id
     * @param name API 分类名
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam Long sort, @RequestParam String remark) {
        ApiCategoryEntity apiCategoryEntity = null;
        Date date = new Date();
        try {
            apiCategoryEntity = apiCategoryMapper.getOne(id);
            apiCategoryEntity.setName(name);
            apiCategoryEntity.setSort(sort);
            apiCategoryEntity.setRemark(remark);
            apiCategoryEntity.setGmtModified(date);
            apiCategoryMapper.updateOne(apiCategoryEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiCategoryEntity, HttpStatus.OK);
    }

    /**
     * 指定 API 分类 id ，批量删除 API 分类
     *
     * @param idList API 分类 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;

        try {

            for (Long id : idList) {
                ApiCategoryEntity viewPageCategoryEntity = apiCategoryMapper.getOneByParentId(id);
                if (viewPageCategoryEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_API_CATEGORY_FAIL1);
                }
                ApiEntity apiEntity = apiMapper.getOneByApiCategoryId(id);
                if (apiEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_API_CATEGORY_FAIL2);
                }
            }
            result = apiCategoryMapper.deleteAll(idList);

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
     * 指定 API 分类 id ，获取 API 分类信息
     *
     * @param id API 分类 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + API_CATEGORY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ApiCategoryEntity apiCategoryEntity = null;
        try {
            apiCategoryEntity = apiCategoryMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiCategoryEntity, HttpStatus.OK);
    }

}
