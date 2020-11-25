package com.bxbro.web.service.impl;

import com.bxbro.common.constant.FileType;
import com.bxbro.web.config.ResourcePathConfig;
import com.bxbro.web.service.ResourcePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/25
 */
@Service
public class ResourcePathServiceImpl implements ResourcePathService {

    @Autowired
    private ResourcePathConfig resourcePathConfig;

    @Override
    public String getResourcePath(Integer fileType) {
        String relativePath = "";
        switch (fileType) {
            case FileType.PICTURE:
                relativePath = resourcePathConfig.getPicDir();
                break;
            case FileType.AUDIO:
                relativePath = resourcePathConfig.getAudioDir();
                break;
            case FileType.VIDEO:
                relativePath = resourcePathConfig.getVideoDir();
                break;
            default:
                break;
        }
        return relativePath;
    }
}
