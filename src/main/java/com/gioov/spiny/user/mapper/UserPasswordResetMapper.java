package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.UserPasswordResetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Mapper
@Component("userPasswordResetMapper")
public interface UserPasswordResetMapper extends CrudMapper<UserPasswordResetEntity, Long> {

}
