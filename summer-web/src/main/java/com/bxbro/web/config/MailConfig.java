package com.bxbro.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 邮件发送的配置类
 * @Author dong
 * @Date 2020/12/4
 */
@Configuration
public class MailConfig {

    /**-----邮件主题------**/
    @Value("${summer.mail.subject}")
    private String subject;

    /**-----邮件内容------**/
    @Value("${summer.mail.content}")
    private String content;

    /**-----邮件送达者地址------**/
    @Value("${summer.mail.from-address}")
    private String toAddress;

    /**-----邮件发送者地址------**/
    @Value("${summer.mail.to-address}")
    private String fromAddress;

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }
}
