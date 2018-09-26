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
@RequestMapping(Page.System.DICTIONARY)
public class DictionaryController {

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/DICTIONARY/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return Page.System.DICTIONARY + "/page_all";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/add_dialog")
    public String addDialog() {
        return Page.System.DICTIONARY + "/add_dialog";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.System.DICTIONARY + "/edit_dialog";
    }

}
