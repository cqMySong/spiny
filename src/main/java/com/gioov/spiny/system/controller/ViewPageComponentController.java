package com.gioov.spiny.system.controller;

import com.gioov.spiny.common.constant.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Controller
@RequestMapping(Page.System.VIEW_PAGE_COMPONENT)
public class ViewPageComponentController {

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/VIEW_PAGE_COMPONENT/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return Page.System.VIEW_PAGE_COMPONENT + "/page_all";
    }

    @RequestMapping("/add_dialog")
    public String addDialog() {
        return Page.System.VIEW_PAGE_COMPONENT + "/add_dialog";
    }

    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.System.VIEW_PAGE_COMPONENT + "/edit_dialog";
    }

}
