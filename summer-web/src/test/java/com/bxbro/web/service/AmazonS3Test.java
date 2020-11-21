package com.bxbro.web.service;

import com.amazonaws.services.s3.model.Bucket;
import com.bxbro.amazons3.util.AmazonS3Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AmazonS3Test {

    @Test
    public void testListBuckets() {
        List<Bucket> buckets = AmazonS3Util.listBuckets();
        System.out.println(buckets);
    }
}
