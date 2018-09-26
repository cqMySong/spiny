package com.gioov.spiny.system.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.system.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Mapper
@Component("departmentMapper")
public interface DepartmentMapper extends CrudMapper<DepartmentEntity, Long> {

}
