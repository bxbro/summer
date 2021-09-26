package com.bxbro.summer.web.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dong
 * @description feign的日志配置类
 * @date 2021/9/26
 */
@Configuration
public class FeignLogConfiguration {

    /**
     * Feign客户端默认的日志级别是NONE，该级别不会记录任何Feign调用过程中的信息，
     * 所以此处增加配置类，将日志级别调整为 FULL
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
