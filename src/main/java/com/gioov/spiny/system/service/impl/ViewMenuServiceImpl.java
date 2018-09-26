package com.gioov.spiny.system.service.impl;

import com.gioov.spiny.system.service.ViewMenuService;
import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;
import com.gioov.spiny.user.entity.ViewMenuEntity;
import com.gioov.spiny.user.mapper.UserRoleMapper;
import com.gioov.spiny.user.mapper.ViewMenuMapper;
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
public class ViewMenuServiceImpl implements ViewMenuService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private ViewMenuMapper viewMenuMapper;


    @Autowired
    private RoleService roleService;


    /**
     * 指定 userId、menuCategoryId 获取 视图菜单
     *
     * @param userId
     * @param menuCategoryId
     * @return
     */
    @Override
    public List<ViewMenuEntity> listAllByUserIdAndMenuCategoryId(Long userId, Long menuCategoryId) {
        List<ViewMenuEntity> viewMenuCategoryEntityList = null;

        List<UserRoleEntity> userRoleEntityList = null;
        if ((userRoleEntityList = userRoleMapper.listAllByUserId(userId)) != null) {

            List<RoleEntity> roleEntityList = null;

            if ((roleEntityList = roleService.listAllByUserRole(userRoleEntityList)) != null) {
                viewMenuCategoryEntityList = new ArrayList<>();
                for (RoleEntity roleEntity : roleEntityList) {
                    viewMenuCategoryEntityList.addAll(viewMenuMapper.listAllByMenuCategoryIdAndRoleId(menuCategoryId, roleEntity.getId()));
                }
            }
        }
        return viewMenuCategoryEntityList;
    }
}
