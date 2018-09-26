package com.gioov.spiny.user.service;

import com.gioov.spiny.common.security.SimpleUser;
import com.gioov.spiny.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface UserService {

    public static final String SYSTEM_ADMIN = "SYSTEM_ADMIN";

    /**
     * 指定用户 id 、密码，获取用户
     *
     * @param id 用户 id
     * @param password 用户密码
     * @return UserEntity
     */
    UserEntity getOneByIdAndPassword(Long id, String password);

    /**
     * 指定用户名、密码，获取用户
     *
     * @param username 用户名
     * @param password 用户密码
     * @return UserEntity
     */
    UserEntity getOneByUsernameAndPassword(String username, String password);

    /**
     * 指定电子邮箱、密码，获取用户
     *
     * @param email 电子邮箱
     * @param password 用户密码
     * @return UserEntity
     */
    UserEntity getOneByEmailAndPassword(String email, String password);

    /**
     * 指定手机号、密码，获取用户
     *
     * @param cellphone 手机号
     * @param password 用户密码
     * @return UserEntity
     */
    UserEntity getOneByCellphoneAndPassword(String cellphone, String password);

    /**
     * 校验密码是否正确
     *
     * @param plainPassword 明文密码
     * @param cipherPassword 密文密码
     * @return boolean
     */
    boolean checkPassword(String plainPassword, String cipherPassword);

    /**
     * 加密明文密码
     *
     * @param plainPassword 明文密码
     * @return String
     */
    String encodePassword(String plainPassword);

    /**
     * 指定 HttpServletRequest ，获取 user principal
     *
     * @param request HttpServletRequest
     * @return SimpleUser
     */
    SimpleUser getUserPrincipal(HttpServletRequest request);

    /**
     * 指定用户 id ，获取用户
     *
     * @param id 用户 id
     * @return UserEntity
     */
    UserEntity getOneByIdNoPassword(Long id);

    /**
     * 伪删除用户
     *
     * @param idList id list
     */
    void fakeDeleteAll(List<Long> idList);

    /**
     * 撤销伪删除用户
     *
     * @param idList 用户 id list
     */
    void revokeFakeDeleteAll(List<Long> idList);

    /**
     * 可能会 null
     *
     * @return UserEntity
     */
    UserEntity getCurrentUser();

    /**
     * 更可靠的获取
     *
     * @param request HttpServletRequest
     * @return UserEntity
     */
    UserEntity getCurrentUser(HttpServletRequest request);
}



