package com.gioov.spiny.system.service.impl;

import com.gioov.spiny.system.service.ViewMenuCategoryService;
import com.gioov.spiny.user.entity.RoleEntity;
import com.gioov.spiny.user.entity.UserRoleEntity;
import com.gioov.spiny.user.entity.ViewMenuCategoryEntity;
import com.gioov.spiny.user.mapper.UserMapper;
import com.gioov.spiny.user.mapper.UserRoleMapper;
import com.gioov.spiny.user.mapper.ViewMenuCategoryMapper;
import com.gioov.spiny.user.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class ViewMenuCategoryServiceImpl implements ViewMenuCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewMenuCategoryServiceImpl.class);
    @Autowired
    private ViewMenuCategoryMapper viewMenuCategoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleService roleService;

    /**
     * 指定 用户id，获取所有视图菜单父级分类
     *
     * @param userId
     * @return
     */
    @Override
    public List<ViewMenuCategoryEntity> listAllParentByUserId(Long userId) {

        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;

        List<UserRoleEntity> userRoleEntityList = null;
        if ((userRoleEntityList = userRoleMapper.listAllByUserId(userId)) != null) {

            List<RoleEntity> roleEntityList = null;

            if ((roleEntityList = roleService.listAllByUserRole(userRoleEntityList)) != null) {
                viewMenuCategoryEntityList = new ArrayList<>();
                for (RoleEntity roleEntity : roleEntityList) {
                    viewMenuCategoryEntityList.addAll(viewMenuCategoryMapper.listAllByParentIdIsNullAndRoleId(roleEntity.getId()));
                }
            }
        }
        return viewMenuCategoryEntityList;
    }

    /**
     * 指定 用户id、视图菜单父级分类，获取所有视图菜单子级分类
     *
     * @param userId
     * @param parentId
     * @return
     */
    @Override
    public List<ViewMenuCategoryEntity> listAllChildByParentIdAndUserId(Long parentId, Long userId) {

        List<ViewMenuCategoryEntity> viewMenuCategoryEntityList = null;

        List<UserRoleEntity> userRoleEntityList = null;
        if ((userRoleEntityList = userRoleMapper.listAllByUserId(userId)) != null) {

            List<RoleEntity> roleEntityList = null;

            if ((roleEntityList = roleService.listAllByUserRole(userRoleEntityList)) != null) {
                viewMenuCategoryEntityList = new ArrayList<>();
                for (RoleEntity roleEntity : roleEntityList) {

                    // 根据父级视图菜单分类和角色 id ，获取每个角色所拥有的视图菜单子级分类
                    viewMenuCategoryEntityList.addAll(viewMenuCategoryMapper.listAllByParentIdAndRoleId(parentId, roleEntity.getId()));
                }
            }
        }
        return viewMenuCategoryEntityList;
    }

}
