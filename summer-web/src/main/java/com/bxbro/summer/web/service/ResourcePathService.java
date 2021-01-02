package com.bxbro.summer.web.service;

/**
 *@Description 资源路径api
 *@Author dong
 *@Date 2020/12/29
 */
public interface ResourcePathService {
    /**
    * 根据不同的文件类型获取不同的存放路径
    * @author dong
    * @date 2020/11/25
    * @param fileType
    * @return 返回的是相对路径
    */
    String getResourcePath(Integer fileType);
}
