package com.gioov.spiny.user.service;

import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface RoleService {

    /**
     * 指定用户角色 list ，获取所有角色
     *
     * @param userRoleEntityList 用户角色 list
     * @return List<RoleEntity>
     */
    List<RoleEntity> listAllByUserRole(List<UserRoleEntity> userRoleEntityList);

}
