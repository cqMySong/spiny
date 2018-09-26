package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.mybatis.Sort;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.EmailEntity;
import com.gioov.spiny.system.mapper.EmailMapper;
import com.gioov.spiny.system.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping(Api.System.EMAIL)
public class EmailRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailRestController.class);

    private static final String EMAIL = "/API/SYSTEM/EMAIL";

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailService emailService;

    /**
     * 分页获取所有邮件队列
     *
     * @param page 页
     * @param rows 每页显示数量
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/PAGE_ALL_QUEUE')")
    @RequestMapping(value = "/page_all_queue", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllQueue(@RequestParam Integer page, @RequestParam Integer rows) {
        List<EmailEntity> emailEntityList = null;
        Pagination.Result<EmailEntity> paginationResult = new Pagination().new Result<>();

        Sort sort = new Sort(Sort.Direction.DESC, "gmt_created");

        try {
            emailEntityList = emailMapper.pageAll(new Pageable(page, rows, sort));
            if (emailEntityList != null) {
                paginationResult.setRows(emailEntityList);
            }
            int count = emailMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }


    /**
     * 新增邮件
     *
     * @param from 发件人电子邮箱
     * @param to 收件人电子邮箱
     * @param subject 电子邮件主题
     * @param text 电子邮件文本内容
     * @param html 电子邮件是否为 html
     * @param remark 备注
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String from, @RequestParam String to, @RequestParam String subject, @RequestParam String text, @RequestParam Integer html, @RequestParam String remark) {
        EmailEntity emailEntity = null;
        try {
            emailEntity = new EmailEntity();
            emailEntity.setFrom(from);
            emailEntity.setTo(to);
            emailEntity.setSubject(subject);
            emailEntity.setText(text);
            emailEntity.setHtml(html);
            emailEntity.setRemark(remark);
            emailService.addQueue(emailEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailEntity, HttpStatus.NO_CONTENT);
    }

    /**
     * 指定邮件 id ，获取邮件信息
     *
     * @param id 电子邮件 id
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        EmailEntity emailEntity = null;
        try {
            emailEntity = emailMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailEntity, HttpStatus.OK);
    }


    /**
     * 指定队列邮件 id ，批量删除队列邮件
     *
     * @param idList 电子邮件 id list
     * @return ResponseEntity<? extends Object>
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {
            result = emailMapper.deleteAll(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
