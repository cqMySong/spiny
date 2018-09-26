package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.DictionaryEntity;
import com.gioov.spiny.system.mapper.DictionaryMapper;
import com.gioov.spiny.system.service.DictionaryService;
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
import java.util.Map;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.System.DICTIONARY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DictionaryRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewPageRestController.class);

    private static final String DICTIONARY = "/API/SYSTEM/DICTIONARY";

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 指定父级数据字典分类 id ，获取所有数据字典
     *
     * @param page 页
     * @param rows 每页显示数量
     * @param dictionaryCategoryId 数据字典分类 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/PAGE_ALL_BY_DICTIONARY_CATEGORY_ID')")
    @RequestMapping(value = "/page_all_by_dictionary_category_id/{dictionaryCategoryId}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllByDictionaryCategoryId(@RequestParam Integer page, @RequestParam Integer rows, @PathVariable Long dictionaryCategoryId) {
        List<DictionaryEntity> dictionaryEntityList = null;
        Pagination.Result<DictionaryEntity> paginationResult = new Pagination().new Result<>();

        try {
            dictionaryEntityList = dictionaryMapper.pageAllByDictionaryCategoryId(dictionaryCategoryId, new Pageable(page, rows));
            if (dictionaryEntityList != null) {
                paginationResult.setRows(dictionaryEntityList);
            }
            int count = dictionaryMapper.countAllByDictionaryCategoryId(dictionaryCategoryId);
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }


    /**
     * 新增数据字典
     *
     * @param key 数据字典键
     * @param keyName 数据字典键名
     * @param valueName 数据字典值名
     * @param valueSlug 数据字典值别名
     * @param dictionaryCategoryId 数据字典分类 id
     * @param value 数据字典值
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String key, @RequestParam String keyName, @RequestParam String valueName, @RequestParam String valueSlug, @RequestParam String value, @RequestParam Long dictionaryCategoryId, @RequestParam Long sort, @RequestParam String remark) {
        DictionaryEntity dictionaryEntity = null;
        Date date = new Date();
        try {
            key = key.toUpperCase();
            valueSlug = valueSlug.toUpperCase();
            dictionaryEntity = new DictionaryEntity();
            dictionaryEntity.setKey(key);
            dictionaryEntity.setKeyName(keyName);
            dictionaryEntity.setValueName(valueName);
            dictionaryEntity.setValueSlug(valueSlug);
            dictionaryEntity.setValue(value);
            dictionaryEntity.setDictionaryCategoryId(dictionaryCategoryId);
            dictionaryEntity.setSort(sort);
            dictionaryEntity.setRemark(remark);
            dictionaryEntity.setGmtModified(date);
            dictionaryEntity.setGmtCreated(date);
            dictionaryMapper.insertOne(dictionaryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryEntity, HttpStatus.OK);
    }

    /**
     * 保存数据字典
     *
     * @param id 数据字典 id
     * @param key 数据字典键
     * @param keyName 数据字典键名
     * @param valueName 数据字典值名
     * @param valueSlug 数据字典值别名
     * @param value 数据字典值
     * @param sort 排序
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String key, @RequestParam String keyName, @RequestParam String valueName, @RequestParam String valueSlug, @RequestParam String value, @RequestParam Long sort, @RequestParam String remark) {
        DictionaryEntity dictionaryEntity = null;
        Date date = new Date();
        try {
            key = key.toUpperCase();
            valueSlug = valueSlug.toUpperCase();
            dictionaryEntity = dictionaryMapper.getOne(id);
            dictionaryEntity.setKey(key);
            dictionaryEntity.setKeyName(keyName);
            dictionaryEntity.setValueName(valueName);
            dictionaryEntity.setValueSlug(valueSlug);
            dictionaryEntity.setValue(value);
            dictionaryEntity.setSort(sort);
            dictionaryEntity.setRemark(remark);
            dictionaryEntity.setGmtModified(date);
            dictionaryMapper.updateOne(dictionaryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryEntity, HttpStatus.OK);
    }


    /**
     * 指定数据字典 id ， 批量删除数据字典
     *
     * @param idList 数据字典 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = dictionaryMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定数据字典 id ，获取数据字典信息
     *
     * @param id 数据字典 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        DictionaryEntity dictionaryEntity = null;
        try {
            dictionaryEntity = dictionaryMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryEntity, HttpStatus.OK);
    }

    /**
     * 获取所有数据字典
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/LIST_ALL')")
    @RequestMapping("/list_all")
    public ResponseEntity<? extends Object> listAll() {
        Map<String, Map<String, Object>> map = null;
        try {
            map = dictionaryService.keyValueMap();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 指定数据字典键 ，从内存中获取所有数据字典
     *
     * @param key 数据字典键
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/LIST_ALL_BY_KEY')")
    @RequestMapping("/list_all_by_key/{key}")
    public ResponseEntity<? extends Object> listAllByKey(@PathVariable String key) {
        List<DictionaryEntity> dictionaryEntityList = null;
        try {
            key = key.toUpperCase();
            dictionaryEntityList = dictionaryService.listAllByKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dictionaryEntityList, HttpStatus.OK);
    }

    /**
     * 同步数据字典到内存中
     *
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + DICTIONARY + "/SYNC_TO_MEMORY')")
    @RequestMapping(value = "/sync_to_memory", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> syncToMemory() {
        try {

            dictionaryService.addDictionaryToServletContext();

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ArrayList<>(0), HttpStatus.OK);
    }


}
