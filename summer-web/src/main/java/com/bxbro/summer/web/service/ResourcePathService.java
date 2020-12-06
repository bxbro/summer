package com.bxbro.summer.web.service;

public interface ResourcePathService {

    /**
     *@Description 根据不同的文件类型获取不同的存放路径
     *@Author dong
     *@Date 2020/11/25
     *@Return 返回的是相对路径
     */
    String getResourcePath(Integer fileType);
}
