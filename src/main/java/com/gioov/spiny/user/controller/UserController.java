package com.gioov.spiny.user.controller;

import com.gioov.spiny.common.annotation.operationlog.OperationLog;
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
@RequestMapping(Page.USER)
public class UserController {

    @OperationLog("登录页")
    @RequestMapping("/login")
    public String login() {
        return Page.User.LOGIN;
    }

//    @GetMapping(value="/logout")
//    public String logout (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null){
//            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
//        }
//        //You can redirect wherever you want, but generally it's a good practice to show login screen again.
//        return "redirect:" +  Page.User.LOGIN;
//    }

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/USER/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return Page.USER + "/page_all";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/add_dialog")
    public String addDialog() {
        return Page.USER + "/add_dialog";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.USER + "/edit_dialog";
    }

}
