package com.gioov.spiny.system.service;

import com.gioov.spiny.user.entity.ViewMenuEntity;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface ViewMenuService {

    /**
     * 指定用户 id 、 视图菜单分类 id ，获取所有视图菜单
     *
     * @param userId 用户 id
     * @param menuCategoryId 视图菜单分类 id
     * @return List<ViewMenuEntity>
     */
    List<ViewMenuEntity> listAllByUserIdAndMenuCategoryId(Long userId, Long menuCategoryId);

}
