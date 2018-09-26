package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.mybatis.Sort;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.annotation.operationlog.OperationLog;
import com.gioov.spiny.common.annotation.operationlog.OperationLogTypeEnum;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.OperationLogEntity2;
import com.gioov.spiny.system.mapper.OperationLogMapper;
import com.gioov.spiny.system.mapper.OperationLogMapper2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(value = Api.System.OPERATION_LOG, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperationLogRestController {

    private static final String OPERATION_LOG = "/API/SYSTEM/OPERATION_LOG";

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationLogRestController.class);

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private OperationLogMapper2 operationLogMapper2;

    /**
     * 分页获取所有操作日志
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @OperationLog(value = "分页获取所有操作日志", type = OperationLogTypeEnum.API)
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + OPERATION_LOG + "/PAGE_ALL')")
    @RequestMapping(value = "/page_all", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<OperationLogEntity2> operationLogEntity2List = null;
        Pagination.Result<OperationLogEntity2> paginationResult = new Pagination().new Result<>();

        try {

            Sort sort = new Sort( Sort.Direction.DESC, "gmt_created");
            operationLogEntity2List = operationLogMapper2.pageAll(new Pageable(page, rows, sort));
            if (operationLogEntity2List != null) {
                paginationResult.setRows(operationLogEntity2List);
            }
            int count = operationLogMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }


    /**
     * 指定操作日志 id ，批量删除操作日志
     *
     * @param idList API 分类 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + OPERATION_LOG + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;

        try {

            result = operationLogMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定操作日志 id ，获取操作日志信息
     *
     * @param id 操作日志 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + OPERATION_LOG + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        OperationLogEntity2 operationLogEntity2 = null;
        try {
            operationLogEntity2 = operationLogMapper2.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(operationLogEntity2, HttpStatus.OK);
    }

}
