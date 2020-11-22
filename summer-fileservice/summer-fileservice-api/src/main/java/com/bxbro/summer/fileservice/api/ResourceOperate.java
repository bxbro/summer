package com.bxbro.summer.fileservice.api;

import com.bxbro.summer.fileservice.api.exception.FileServiceException;

public interface ResourceOperate {
    /**
     * 上传文件
     * @param relativePath
     * @param bytes
     * @return
     * @throws FileServiceException
     */
    boolean put(String relativePath, byte[] bytes) throws FileServiceException;

    /**
     * 删除文件
     * @param relativePath
     * @return
     * @throws FileServiceException
     */
    boolean delete(String relativePath) throws FileServiceException;

    /**
     * 下载文件
     * @param relativePath
     * @return
     * @throws FileServiceException
     */
    byte[] get(String relativePath) throws FileServiceException;

    /**
     * 判断某个文件是否存在
     * @param relativePath
     * @return
     * @throws FileServiceException
     */
    boolean exist(String relativePath) throws FileServiceException;
}
