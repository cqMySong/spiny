package com.gioov.spiny.user.service.impl;

import com.gioov.common.crypto.BCryptEncoderUtil;
import com.gioov.common.util.DateUtil;
import com.gioov.spiny.common.security.SimpleUser;
import com.gioov.spiny.common.security.SimpleUserDetails;
import com.gioov.spiny.user.entity.UserEntity;
import com.gioov.spiny.user.mapper.UserMapper;
import com.gioov.spiny.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getOneByIdAndPassword(Long id, String password) {
        UserEntity userEntity = userMapper.getOne(id);
        if (userEntity.getId().equals(id) && checkPassword(password, userEntity.getPassword())) {
            return userEntity;
        }
        return null;
    }

    @Override
    public UserEntity getOneByUsernameAndPassword(String username, String password) {
//        UserEntity userEntity = userMapper.getOneByUsername(username);
//        if(userEntity.getUsername().equals(username) && checkPassword(password, userEntity.getPassword())){
//            return userEntity;
//        }
        return null;
    }

    @Override
    public UserEntity getOneByEmailAndPassword(String email, String password) {
//        UserEntity userEntity = userMapper.getOneByEmail(email);
//        if(userEntity.getEmail().equals(email) && checkPassword(password, userEntity.getPassword())){
//            return userEntity;
//        }
        return null;
    }

    @Override
    public UserEntity getOneByCellphoneAndPassword(String cellphone, String password) {
//        UserEntity userEntity = userMapper.getOneByCellphone(cellphone);
//        if(userEntity.getCellphone().equals(cellphone) && checkPassword(password, userEntity.getPassword())){
//            return userEntity;
//        }
        return null;
    }

    @Override
    public boolean checkPassword(String plainPassword, String cipherPassword) {
        return BCryptEncoderUtil.matches(plainPassword, cipherPassword);
    }

    @Override
    public String encodePassword(String plainPassword) {
        return BCryptEncoderUtil.encode(plainPassword);
    }

    @Override
    public SimpleUser getUserPrincipal(HttpServletRequest request) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContextImpl != null) {
            return (SimpleUser) securityContextImpl.getAuthentication().getPrincipal();
        }
        return null;
    }

    @Override
    public UserEntity getOneByIdNoPassword(Long id) {
        UserEntity userEntity = userMapper.getOne(id);
        if (userEntity != null) {
            userEntity.setPassword(null);
            return userEntity;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void fakeDeleteAll(List<Long> idList) {
        userMapper.fakeDeleteAll(idList, DateUtil.newDate());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void revokeFakeDeleteAll(List<Long> idList) {
        userMapper.revokeFakeDeleteAll(idList);
    }

    @Override
    public UserEntity getCurrentUser() {
        UserEntity userEntity = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            SimpleUserDetails simpleUserDetails = (SimpleUserDetails) principal;
            userEntity = userMapper.getOne(simpleUserDetails.getId());
        }
        return userEntity;
    }

    /**
     * 更可靠的获取
     *
     * @param request HttpServletRequest
     * @return UserEntity
     */
    @Override
    public UserEntity getCurrentUser(HttpServletRequest request) {
        UserEntity userEntity = null;
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContextImpl != null) {
            Object principal = securityContextImpl.getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                SimpleUserDetails simpleUserDetails = (SimpleUserDetails) principal;
                userEntity = userMapper.getOne(simpleUserDetails.getId());
            }
        }
        return userEntity;
    }
}
