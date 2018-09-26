package com.gioov.spiny.system.service;

import com.gioov.spiny.user.entity.ViewMenuCategoryEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface ViewMenuCategoryService {

    /**
     * 指定用户 id ，获取视图菜单分类
     *
     * @param userId 用户 id
     * @return List<ViewMenuCategoryEntity>
     */
    List<ViewMenuCategoryEntity> listAllParentByUserId(Long userId);

    /**
     * 指定视图菜单分类父级 id 、用户 id ，获取视图菜单分类
     *
     * @param parentId 视图页面分类父级 id
     * @param userId 用户 id
     * @return List<ViewMenuCategoryEntity>
     */
    List<ViewMenuCategoryEntity> listAllChildByParentIdAndUserId(Long parentId, Long userId);
}
