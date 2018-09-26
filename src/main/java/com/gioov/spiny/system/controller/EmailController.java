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
@RequestMapping(Page.System.EMAIL)
public class EmailController {

    /**
     * 邮件队列 页面
     *
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/EMAIL/PAGE_ALL_QUEUE')")
    @RequestMapping("/page_all_queue")
    public String pageAllQueue() {
        return Page.System.EMAIL + "/page_all_queue";
    }

    /**
     * 发送邮件 页面
     *
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/EMAIL/SEND')")
    @RequestMapping("/send")
    public String send() {
        return Page.System.EMAIL + "/send";
    }


    /**
     * 编辑重发 对话框
     *
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_and_send_dialog")
    public String editAndSendDialog() {
        return Page.System.EMAIL + "/edit_and_send_dialog";
    }


    /**
     * 编辑对话框 用于测试。
     *
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/edit_dialog")
    public String editDialog() {
        return Page.System.EMAIL + "/edit_dialog";
    }


}
