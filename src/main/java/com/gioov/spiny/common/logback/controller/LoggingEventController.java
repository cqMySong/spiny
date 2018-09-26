package com.gioov.spiny.common.logback.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Controller
@RequestMapping("/logback/logging_event")
public class LoggingEventController {

    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/LOGBACK/LOGGING_EVENT/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return "/logback/logging_event/page_all";
    }

}
