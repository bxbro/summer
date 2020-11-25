package com.bxbro.web.controller;

import com.bxbro.common.resp.BaseResponse;
import com.bxbro.summer.fileservice.api.ResourceOperate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@Api(value = "文件管理", tags = "文件管理")
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private ResourceOperate resourceOperate;


    /**
     *@Description 文件上传
     *@Author dong
     *@Date 2020/11/25
     */
    @ApiOperation("文件上传")
    @PostMapping
    public BaseResponse uploadFile(MultipartFile file) {
        try {
            resourceOperate.put("/pic/"+System.currentTimeMillis()+file.getOriginalFilename(), file.getBytes());
        } catch (IOException e) {
            logger.error("文件上传失败", e);
        }
        return BaseResponse.successMsg("文件上传成功~");
    }

}
