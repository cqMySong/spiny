package com.gioov.spiny.user.controller;

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
@RequestMapping(Page.User.ROLE_AUTHORITY)
public class RoleAuthorityController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/add_dialog")
    public String addDialog() {
        return Page.User.ROLE_AUTHORITY + "/add_dialog";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.User.ROLE_AUTHORITY + "/edit_dialog";
    }

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/USER/ROLE_AUTHORITY/VIEW_PAG/PAGE_ALL')")
    @RequestMapping("/view_page/page_all")
    public String viewPagePageAll() {
        return Page.User.ROLE_AUTHORITY + "/view_page/page_all";
    }

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/USER/ROLE_AUTHORITY/API/PAGE_ALL')")
    @RequestMapping("/api/page_all")
    public String apiPageAll() {
        return Page.User.ROLE_AUTHORITY + "/api/page_all";
    }

}
