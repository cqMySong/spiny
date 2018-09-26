package com.gioov.spiny.system.service.impl;

import com.gioov.common.util.DateUtil;
import com.gioov.spiny.common.constant.Constant;
import com.gioov.spiny.common.email.EmailQueue;
import com.gioov.spiny.system.entity.EmailEntity;
import com.gioov.spiny.system.mapper.EmailMapper;
import com.gioov.spiny.system.service.DictionaryService;
import com.gioov.spiny.system.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private EmailMapper emailMapper;

    private JavaMailSenderImpl javaMailSender;

    public void initialize() {
        javaMailSender = new JavaMailSenderImpl();
        String host = dictionaryService.get("MAIL", "HOST");
        if (host != null) {
            javaMailSender.setHost(host);
        }
        String protocol = dictionaryService.get("MAIL", "PROTOCOL");
        if (protocol != null) {
            javaMailSender.setProtocol(protocol);
        }
        String port = dictionaryService.get("MAIL", "PORT");
        if (port != null) {
            javaMailSender.setPort(Integer.valueOf(port));
        }
        String username = dictionaryService.get("MAIL", "USERNAME");
        if (username != null) {
            javaMailSender.setUsername(username);
        }
        String password = dictionaryService.get("MAIL", "PASSWORD");
        if (password != null) {
            javaMailSender.setPassword(password);
        }
        String defaultEncoding = dictionaryService.get("MAIL", "DEFAULT_ENCODING");
        if (password != null) {
            javaMailSender.setPassword(password);
        }
        javaMailSender.setDefaultEncoding(defaultEncoding);

        Properties properties = new Properties();
        String smtpAuth = dictionaryService.get("MAIL", "SMTP_AUTH");
        if (smtpAuth != null) {
            properties.setProperty("mail.smtp.auth", smtpAuth);
        }
        String startTlsEnable = dictionaryService.get("MAIL", "STARTTLS_ENABLE");
        if (startTlsEnable != null) {
            properties.setProperty("mail.starttls.enable", startTlsEnable);
        }
        String startTlsRequired = dictionaryService.get("MAIL", "STARTTLS_REQUIRED");
        if (startTlsRequired != null) {
            properties.setProperty("mail.starttls.required", startTlsRequired);
        }
        javaMailSender.setJavaMailProperties(properties);
    }

    @Override
    public void addQueue(EmailEntity emailEntity) {
        Integer status = emailEntity.getStatus();

        if (status != null && status != Constant.SmsStatus.WAIT) {
            emailEntity.setStatus(Constant.SmsStatus.WAIT);
        } else {
            emailEntity.setStatus(Constant.SmsStatus.WAIT);
        }
        Date now = DateUtil.newDate();
        emailEntity.setGmtModified(now);
        emailEntity.setGmtCreated(now);
        setFrom(emailEntity);
        if (emailMapper.insertOne(emailEntity) >= 1) {
            try {
                EmailQueue.getEmailQueue().produce(emailEntity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setFrom(EmailEntity emailEntity) {
        String from = emailEntity.getFrom();
        if (from == null) {
            from = dictionaryService.get("MAIL", "FROM");
            if (from != null) {
                emailEntity.setFrom(from);
            }
        }
    }

    @Override
    public void send(EmailEntity emailEntity) {

        EmailEntity emailEntity1 = emailMapper.getOne(emailEntity.getId());

        LOGGER.info("send ...");
        if (emailEntity1 != null) {
            if (emailEntity1.getStatus() != Constant.SmsStatus.FAIL) {
                emailEntity1.setStatus(Constant.SmsStatus.FAIL);
            }
            try {

                if (emailEntity1.getHtml() == Constant.IsOrNot.IS) {
                    sendMimeEmailMessage(emailEntity1.getFrom(), emailEntity1.getTo(), emailEntity1.getSubject(), emailEntity1.getText(), true);
                    if (emailEntity1.getStatus() != Constant.SmsStatus.SUCCESS) {
                        emailEntity1.setStatus(Constant.SmsStatus.SUCCESS);
                    }

                } else {
                    sendSimpleEmailMessage(emailEntity.getFrom(), emailEntity1.getTo(), emailEntity1.getSubject(), emailEntity1.getText());
                    if (emailEntity1.getStatus() != Constant.SmsStatus.SUCCESS) {
                        emailEntity1.setStatus(Constant.SmsStatus.SUCCESS);
                    }
                    LOGGER.info("send end");

                }

                emailEntity1.setGmtModified(DateUtil.newDate());
            } catch (Exception e) {
                LOGGER.info("e={}", e);
                emailEntity1.setError(e.getMessage());
            }

            emailMapper.updateOne(emailEntity1);
        }
    }

    @Override
    public void sendSimpleEmailMessage(String from, String to, String subject, String text) throws MailException {
        initialize();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        if (from != null) {
            simpleMailMessage.setFrom(from);
        }
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendMimeEmailMessage(String from, String to, String subject, String text, boolean html) throws MessagingException, MailException {
        initialize();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessage.setSubject(subject);
        mimeMessageHelper.setText(text, html);
        javaMailSender.send(mimeMessage);
    }

}
