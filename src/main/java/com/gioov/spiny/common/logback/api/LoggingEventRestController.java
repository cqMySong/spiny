package com.gioov.spiny.common.logback.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Url;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.common.logback.entity.LoggingEventEntity;
import com.gioov.spiny.common.logback.mapper.LoggingEventMapper;
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
@RequestMapping(Url.API + "/logback/logging_event")
public class LoggingEventRestController {

    @Autowired
    private LoggingEventMapper loggingEventMapper;

    @RequestMapping("/page_all")
    public ResponseEntity<? extends Object> pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<LoggingEventEntity> loggingEventEntityList = null;
        Pagination.Result<LoggingEventEntity> paginationResult = new Pagination().new Result<>();

        try {
            loggingEventEntityList = loggingEventMapper.pageAll(new Pageable(page, rows));
            if (loggingEventEntityList != null) {
                paginationResult.setRows(loggingEventEntityList);
            }
            int count = loggingEventMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

}
