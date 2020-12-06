package com.bxbro.summer.web.config;

import com.bxbro.summer.fileservice.api.ResourceOperate;
import com.bxbro.summer.fileservice.local.LocalResourceOperateImpl;
import com.bxbro.summer.fileservice.local.config.LocalFileServiceConfig;
import com.bxbro.summer.fileservice.s3.S3ResourceOperateImpl;
import com.bxbro.summer.fileservice.s3.client.S3Client;
import com.bxbro.summer.fileservice.s3.config.S3FileServiceConfig;
import com.bxbro.summer.web.config.props.FileServiceConfigProps;
import com.bxbro.summer.web.config.props.FileServiceLocalConfigProps;
import com.bxbro.summer.web.config.props.FileServiceS3ConfigProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FileServiceConfigProps.class)
public class FileServiceConfig {


    private static final Logger logger = LoggerFactory.getLogger(FileServiceConfig.class);

    @Autowired
    private FileServiceConfigProps fileServiceConfigProps;


    @Bean
    public ResourceOperate resourceOperate() {
        ResourceOperate resourceOperate;
        String serviceType = fileServiceConfigProps.getServiceType();
        if (FileServiceConfigProps.SERVICE_TYPE_LOCAL.equals(serviceType)) {
            resourceOperate = initLocalFileService();
        } else if (FileServiceConfigProps.SERVICE_TYPE_S3.equals(serviceType)) {
            resourceOperate = initS3FileService();
        } else {
            throw new RuntimeException("未知的文件服务类型：" + serviceType);
        }
        return resourceOperate;
    }


    // 外网调试S3接口使用 todo
    @Bean
    public S3Client s3Client() {
        FileServiceS3ConfigProps s3ConfigProps = fileServiceConfigProps.getS3();
        S3FileServiceConfig config = new S3FileServiceConfig();
        BeanUtils.copyProperties(s3ConfigProps, config);
        return new S3Client(config);
    }


    private ResourceOperate initS3FileService() {
        logger.info("初始化S3文件存储服务");
        FileServiceS3ConfigProps s3ConfigProps = fileServiceConfigProps.getS3();
        S3FileServiceConfig config = new S3FileServiceConfig();
        BeanUtils.copyProperties(s3ConfigProps, config);
        S3Client s3Client = new S3Client(config);
        S3ResourceOperateImpl s3 = new S3ResourceOperateImpl(s3Client);
        logger.info("初始化S3文件存储服务完成.");
        return s3;
    }

    private ResourceOperate initLocalFileService() {
        logger.info("初始化本地文件存储服务");
        FileServiceLocalConfigProps localConfigProps = fileServiceConfigProps.getLocal();
        LocalFileServiceConfig config = new LocalFileServiceConfig();
        BeanUtils.copyProperties(localConfigProps, config);
        LocalResourceOperateImpl local = new LocalResourceOperateImpl(config);
        logger.info("初始化本地文件存储服务完成.");
        return local;
    }

}
