package com.gioov.spiny.user.mapper;

import com.gioov.common.mybatis.CrudMapper;
import com.gioov.spiny.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Mapper
@Component("userMapper")
public interface UserMapper extends CrudMapper<UserEntity, Long> {

    /**
     * 指定 username 获取用户
     *
     * @param username 用户名
     * @return UserEntity
     */
    UserEntity getOneByUsername(@Param("username") String username);

    /**
     * 伪删除用户，标记 gmtDeleted 字段
     *
     * @param idList id list
     * @param gmtDeleted 删除时间
     * @return int
     */
    int fakeDeleteAll(@Param("idList") List<Long> idList, @Param("gmtDeleted") Date gmtDeleted);

    /**
     * 撤销伪删除用户，不标记 gmtDeleted 字段
     *
     * @param idList id list
     * @return int
     */
    int revokeFakeDeleteAll(@Param("idList") List<Long> idList);

}
