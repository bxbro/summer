package com.bxbro.amazons3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Amazon S3的连接配置
 * @Author dong
 * @Date 2020/11/21
 */
@Configuration
public class RemoteConfig {

    @Value("${summer.amazons3.accesskey}")
    private String accesskey;

    @Value("${summer.amazons3.secretkey}")
    private String secretkey;

    @Value("${summer.amazons3.endpoint}")
    private String endpoint;

    @Value("${summer.amazons3.region}")
    private String region;

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
