package com.bxbro.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bxbro.common.constant.ResourceStatus;
import com.bxbro.common.entity.File;
import com.bxbro.summer.fileservice.api.ResourceOperate;
import com.bxbro.web.mapper.FileMapper;
import com.bxbro.web.service.IFileService;
import com.bxbro.web.service.ResourcePathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-generator
 * @since 2020-11-29
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private ResourceOperate resourceOperate;
    @Autowired
    private ResourcePathService resourcePathService;
    @Autowired
    private FileMapper fileMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uploadAndSave(MultipartFile file, Integer fileType) throws IOException {

        String relativePath = resourcePathService.getResourcePath(fileType)
                + "/" + System.currentTimeMillis() + file.getOriginalFilename();
        resourceOperate.put(relativePath, file.getBytes());
        logger.info("文件[{}]上传成功", file.getOriginalFilename());

        File newFile = new File();
        newFile.setFileName(file.getOriginalFilename());
        newFile.setFileUrl(relativePath);
        newFile.setFileType(fileType);
        newFile.setCtime(System.currentTimeMillis());
        newFile.setMtime(0L);
        newFile.setDeleted(ResourceStatus.UNDELETED);
        fileMapper.insert(newFile);
        logger.info("文件[{}]入库成功", file.getOriginalFilename());
    }
}
