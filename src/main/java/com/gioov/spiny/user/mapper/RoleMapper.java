package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Mapper
@Component("roleMapper")
public interface RoleMapper extends CrudMapper<RoleEntity, Long> {

    /**
     * 指定角色值，获取角色
     *
     * @param value 角色值
     * @return RoleEntity
     */
    RoleEntity getOneByValue(@Param("value") String value);

}
