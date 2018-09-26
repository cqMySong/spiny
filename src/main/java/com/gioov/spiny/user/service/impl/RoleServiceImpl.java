package com.gioov.spiny.user.service.impl;

import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;
import com.gioov.spiny.user.mapper.RoleMapper;
import com.gioov.spiny.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户关联角色来获取所有角色
     *
     * @param userRoleEntityList 用户角色 list
     * @return List<RoleEntity>
     */
    @Override
    public List<RoleEntity> listAllByUserRole(List<UserRoleEntity> userRoleEntityList) {
        List<RoleEntity> roleEntityList = null;
        if (userRoleEntityList != null && userRoleEntityList.size() > 0) {
            roleEntityList = new ArrayList<>();
            for (UserRoleEntity userRoleEntity : userRoleEntityList) {
                RoleEntity roleEntity = roleMapper.getOne(userRoleEntity.getRoleId());
                roleEntityList.add(roleEntity);
            }
        }
        return roleEntityList;
    }
}
