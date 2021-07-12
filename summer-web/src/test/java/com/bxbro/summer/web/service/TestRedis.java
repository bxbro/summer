package com.bxbro.summer.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

/**
 * @author dong
 * @description TODO
 * @date 2021/7/12
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {

    @Test
    public void testRedis() {
        // 连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 使用jedis对象操作redis服务
//        String res = jedis.ping();
//        System.out.println(res);

        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);

        Long ret = jedis.move("k2", 1);
        System.out.println(ret);


        Transaction transaction = jedis.multi();
        transaction.set("k6", "v6");
        transaction.set("k7", "v7");
        transaction.exec();

    }
}
