package com.bxbro.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 资源路径配置类
 * @Author dong
 * @Date 2020/11/26
 */
@Configuration
public class ResourcePathConfig {

    @Value("${summer.resources.pic-dir}")
    private String picDir;

    @Value("${summer.resources.audio-dir}")
    private String audioDir;

    @Value("${summer.resources.video-dir}")
    private String videoDir;

    public String getPicDir() {
        return picDir;
    }

    public String getAudioDir() {
        return audioDir;
    }

    public String getVideoDir() {
        return videoDir;
    }
}
