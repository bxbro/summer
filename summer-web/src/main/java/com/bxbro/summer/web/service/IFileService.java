package com.bxbro.summer.web.service;

import com.bxbro.summer.common.domain.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-generator
 * @since 2020-11-29
 */
public interface IFileService extends IService<File> {
    /**
     * 上传文件及信息入库
     * @param file
     * @param fileType
     * @throws IOException
     */
    void uploadAndSave(MultipartFile file, Integer fileType) throws IOException;
}
