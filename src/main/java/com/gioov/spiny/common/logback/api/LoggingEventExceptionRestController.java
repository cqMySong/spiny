package com.gioov.spiny.common.logback.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Url;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.common.logback.entity.LoggingEventExceptionEntity;
import com.gioov.spiny.common.logback.mapper.LoggingEventExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(Url.API + "/logback/logging_event_exception")
public class LoggingEventExceptionRestController {

    @Autowired
    private LoggingEventExceptionMapper loggingEventExceptionMapper;

    @RequestMapping("/page_all")
    public ResponseEntity<? extends Object> pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<LoggingEventExceptionEntity> loggingEventExceptionEntityList = null;
        Pagination.Result<LoggingEventExceptionEntity> paginationResult = new Pagination().new Result<>();

        try {
            loggingEventExceptionEntityList = loggingEventExceptionMapper.pageAll(new Pageable(page, rows));
            if (loggingEventExceptionEntityList != null) {
                paginationResult.setRows(loggingEventExceptionEntityList);
            }
            int count = loggingEventExceptionMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

}
