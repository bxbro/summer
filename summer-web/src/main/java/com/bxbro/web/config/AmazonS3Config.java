package com.bxbro.web.config;

import com.bxbro.amazons3.config.RemoteConfig;
import com.bxbro.amazons3.util.AmazonS3Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@Configuration
public class AmazonS3Config {

    @Autowired
    private RemoteConfig remoteConfig;

    @Bean
    public RemoteConfig remoteConfig() {
        return new RemoteConfig();
    }

    @Bean
    public AmazonS3Util amazonS3Util(){
        return new AmazonS3Util(remoteConfig);
    }

}
