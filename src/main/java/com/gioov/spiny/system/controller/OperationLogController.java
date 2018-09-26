package com.gioov.spiny.system.controller;

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
@RequestMapping(Page.System.OPERATION_LOG)
public class OperationLogController {

    @OperationLog("操作日志")
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/API/PAGE_ALL')")
    @RequestMapping("/page_all")
    public String pageAll() {
        return Page.System.OPERATION_LOG + "/page_all";
    }
}
