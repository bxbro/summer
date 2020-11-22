package com.bxbro.summer.fileservice.local;

import com.bxbro.summer.fileservice.api.ResourceOperate;
import com.bxbro.summer.fileservice.api.exception.FileServiceException;
import com.bxbro.summer.fileservice.local.config.LocalFileServiceConfig;
import com.bxbro.summer.fileservice.local.exception.LocalFileServiceException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LocalResourceOperateImpl implements ResourceOperate {


    private LocalFileServiceConfig config;

    public LocalResourceOperateImpl(LocalFileServiceConfig config) {
        this.config = config;
    }

    @Override
    public boolean put(String relativePath, byte[] bytes) throws FileServiceException {
        if (bytes == null) {
            throw new LocalFileServiceException("bytes 为空");
        }
        if (relativePath == null || relativePath.isEmpty()) {
            throw new LocalFileServiceException("relativePath为空");
        }

        String resRootDir = config.getResRootDir();
        String path = resRootDir + File.separator + relativePath;

        try {
            FileUtils.writeByteArrayToFile(new File(path), bytes);
            return true;
        } catch (IOException e){
            throw new LocalFileServiceException(e);
        }
    }

    @Override
    public boolean delete(String relativePath) throws FileServiceException {
        if (relativePath == null || relativePath.isEmpty()) {
            throw new LocalFileServiceException("relativePath为空");
        }

        String resRootDir = config.getResRootDir();
        String path = resRootDir + File.separator + relativePath;

        try {
            FileUtils.forceDelete(new File(path));
            return true;
        } catch (IOException e){
            throw new LocalFileServiceException(e);
        }
    }

    @Override
    public byte[] get(String relativePath) throws FileServiceException {

        if (relativePath == null || relativePath.isEmpty()) {
            throw new LocalFileServiceException("relativePath为空");
        }

        String resRootDir = config.getResRootDir();
        String path = resRootDir + File.separator + relativePath;

        try {
            return FileUtils.readFileToByteArray(new File(path));
        } catch (IOException e){
            throw new LocalFileServiceException(e);
        }
    }

    @Override
    public boolean exist(String relativePath) throws FileServiceException {

        if (relativePath == null || relativePath.isEmpty()) {
            throw new LocalFileServiceException("relativePath为空");
        }

        String resRootDir = config.getResRootDir();
        String path = resRootDir + File.separator + relativePath;

        return new File(path).exists();
    }
}
