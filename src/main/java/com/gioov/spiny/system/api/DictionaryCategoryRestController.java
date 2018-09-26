package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.DictionaryCategoryEntity;
import com.gioov.spiny.system.entity.DictionaryEntity;
import com.gioov.spiny.system.mapper.DictionaryCategoryMapper;
import com.gioov.spiny.system.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(Api.System.DICTIONARY_CATEGORY)
public class DictionaryCategoryRestController {

    private static final String DICTIONARY_CATEGORY = "/API/SYSTEM/DICTIONARY_CATEGORY";

    @Autowired
    private DictionaryCategoryMapper dictionaryCategoryMapper;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 分页获取所有父级数据字典分类
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/PAGE_ALL_PARENT')")
    @RequestMapping(value = "/page_all_parent", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllParent(@RequestParam Integer page, @RequestParam Integer rows) {
        List<DictionaryCategoryEntity> dictionaryCategoryEntityList = null;
        Pagination.Result<DictionaryCategoryEntity> paginationResult = new Pagination().new Result<>();

        try {
            dictionaryCategoryEntityList = dictionaryCategoryMapper.pageAllByParentIdIsNull(new Pageable(page, rows));
            if (dictionaryCategoryEntityList != null) {
                paginationResult.setRows(dictionaryCategoryEntityList);
            }
            int count = dictionaryCategoryMapper.countAllByParentIdIsNull();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 指定父级数据字典分类 id ，获取所有数据字典分类
     *
     * @param parentId 数据字典分类父级 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/LIST_ALL_BY_PARENT_ID')")
    @RequestMapping(value = "/list_all_by_parent_id/{parentId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllByParentId(@PathVariable Long parentId) {
        List<DictionaryCategoryEntity> dictionaryCategoryEntityList = null;

        try {
            dictionaryCategoryEntityList = dictionaryCategoryMapper.listAllByParentId(parentId);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryCategoryEntityList, HttpStatus.OK);
    }


    /**
     * 新增数据字典分类
     *
     * @param name 数据字典分类名
     * @param parentId 数据字典分类父级 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam(required = false) Long parentId, @RequestParam Long sort, @RequestParam String remark) {
        DictionaryCategoryEntity dictionaryCategoryEntity = null;
        Date date = new Date();

        try {
            dictionaryCategoryEntity = new DictionaryCategoryEntity();
            dictionaryCategoryEntity.setName(name);
            dictionaryCategoryEntity.setParentId(parentId);
            dictionaryCategoryEntity.setSort(sort);
            dictionaryCategoryEntity.setRemark(remark);
            dictionaryCategoryEntity.setGmtModified(date);
            dictionaryCategoryEntity.setGmtCreated(date);
            dictionaryCategoryMapper.insertOne(dictionaryCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryCategoryEntity, HttpStatus.OK);
    }

    /**
     * 保存数据字典分类
     *
     * @param id 数据字典分类 id
     * @param name 数据字典分类名
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam Long sort, @RequestParam String remark) {
        DictionaryCategoryEntity dictionaryCategoryEntity = null;
        Date date = new Date();
        try {
            dictionaryCategoryEntity = dictionaryCategoryMapper.getOne(id);
            dictionaryCategoryEntity.setName(name);
            dictionaryCategoryEntity.setSort(sort);
            dictionaryCategoryEntity.setRemark(remark);
            dictionaryCategoryEntity.setGmtModified(date);
            dictionaryCategoryMapper.updateOne(dictionaryCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryCategoryEntity, HttpStatus.OK);
    }


    /**
     * 指定数据字典分类 id ，批量删除数据字典分类
     *
     * @param idList 数据字典分类 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {

            for (Long id : idList) {
                DictionaryCategoryEntity dictionaryCategoryEntity = dictionaryCategoryMapper.getOneByParentId(id);
                if (dictionaryCategoryEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_DICTIONARY_CATEGORY_FAIL1);
                }
                DictionaryEntity dictionaryEntity = dictionaryMapper.getOneByDictionaryCategoryId(id);
                if (dictionaryEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_DICTIONARY_CATEGORY_FAIL2);
                }
            }

            result = dictionaryCategoryMapper.deleteAll(idList);

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
     * 指定数据字典分类 id ，获取数据字典分类信息
     *
     * @param id 数据字典分类 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY_CATEGORY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        DictionaryCategoryEntity dictionaryCategoryEntity = null;
        try {
            dictionaryCategoryEntity = dictionaryCategoryMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryCategoryEntity, HttpStatus.OK);
    }

}
