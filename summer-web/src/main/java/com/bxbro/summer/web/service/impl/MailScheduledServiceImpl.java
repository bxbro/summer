package com.bxbro.summer.web.service.impl;

import com.bxbro.summer.web.config.MailConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Description 定时任务：发送邮件
 * @Author dong
 * @Date 2020/12/2
 */
@Service
public class MailScheduledServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(MailScheduledServiceImpl.class);

    /**
     * 不知道为什么提示注入失败，但是能调得通
     */
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    MailConfig mailConfig;

    @Scheduled(cron = "${summer.mail.cron}")
    public void sendMail() {
        logger.info("---------邮件定时任务 start---------");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(mailConfig.getSubject());
        simpleMailMessage.setText(mailConfig.getContent());
        simpleMailMessage.setFrom(mailConfig.getFromAddress());
        simpleMailMessage.setTo(mailConfig.getToAddress());
        javaMailSender.send(simpleMailMessage);
        logger.info("---------邮件定时任务 end---------");
    }
}
