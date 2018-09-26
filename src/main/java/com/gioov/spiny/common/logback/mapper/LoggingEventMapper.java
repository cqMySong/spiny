package com.gioov.spiny.common.logback.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.common.logback.entity.LoggingEventEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Mapper
@Component("loggingEventMapper")
public interface LoggingEventMapper extends CrudMapper<LoggingEventEntity, Long> {

}
