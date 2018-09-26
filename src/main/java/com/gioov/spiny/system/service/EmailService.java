package com.gioov.spiny.system.service;

import com.gioov.spiny.system.entity.EmailEntity;

import javax.mail.MessagingException;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public interface EmailService {

    /**
     * 将要发送的电子邮件加入发送队列
     *
     * @param emailEntity EmailEntity
     */
    void addQueue(EmailEntity emailEntity);

    /**
     * 发送电子邮件
     *
     * @param emailEntity EmailEntity
     */
    void send(EmailEntity emailEntity);

    /**
     * 发送简单电子邮件
     *
     * @param from 发信邮箱
     * @param to 收信邮箱
     * @param subject 主题
     * @param text 邮箱内容
     */
    void sendSimpleEmailMessage(String from, String to, String subject, String text);

    /**
     * 发送 MIME 电子邮件
     *
     * @param from 发信邮箱
     * @param to 收信邮箱
     * @param subject 主题
     * @param text 邮箱内容
     * @param html 是否 html
     * @throws MessagingException
     */
    void sendMimeEmailMessage(String from, String to, String subject, String text, boolean html) throws MessagingException;

}
