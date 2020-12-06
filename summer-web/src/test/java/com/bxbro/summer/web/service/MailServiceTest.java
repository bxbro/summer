package com.bxbro.summer.web.service;

import com.bxbro.summer.web.service.impl.MailScheduledServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/2
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {

    @Autowired
    MailScheduledServiceImpl mailService;

    @Test
    public void testSendMail() {
        System.out.println("------send mail start-------");
        mailService.sendMail();
        System.out.println("------send mail end-------");
    }
}
