package com.bxbro.summer.fileservice.s3;

import com.bxbro.summer.fileservice.api.ResourceOperate;
import com.bxbro.summer.fileservice.api.exception.FileServiceException;
import com.bxbro.summer.fileservice.s3.client.S3Client;
import com.bxbro.summer.fileservice.s3.config.S3FileServiceConfig;
import com.bxbro.summer.fileservice.s3.exception.S3FileServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件服务 amazon S3实现
 */
public class S3ResourceOperateImpl implements ResourceOperate {


    private static final String DEFAULT_PATH_SEPERATOR_REPLACER = "HHEEXXIINN";

    private S3Client s3Client;

    private S3FileServiceConfig config;

    public S3ResourceOperateImpl(S3Client s3Client) {
        this.s3Client = s3Client;
        this.config = s3Client.getConfig();
    }

    private String relatePath2BucketKey(String relativePath) {
        return relativePath.replaceAll("[/\\\\]", replacer());
    }

    private String bucketKey2relativePath(String bucketKey) {
        return bucketKey.replaceAll(replacer(), "/");
    }

    private String replacer() {
        String replacer = config.getPathSeperatorReplacor();
        if (replacer == null) {
            replacer = DEFAULT_PATH_SEPERATOR_REPLACER;
        }
        return replacer;
    }

    @Override
    public boolean put(String relativePath, byte[] bytes) throws FileServiceException {

        if (bytes == null) {
            throw new S3FileServiceException("bytes 为空");
        }
        if (relativePath == null || relativePath.isEmpty()) {
            throw new S3FileServiceException("relativePath为空");
        }

        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        try {
            String key = relatePath2BucketKey(relativePath);
            s3Client.putStream(config.getS3RootBucketName(), key, stream);
        } catch (Exception e) {
            throw new FileServiceException(e);
        } finally {
            try{
                stream.close();
            } catch (IOException e){
                // ignore
            }
        }
        return false;
    }

    @Override
    public boolean delete(String relativePath) throws FileServiceException {

        if (relativePath == null || relativePath.isEmpty()) {
            throw new S3FileServiceException("relativePath为空");
        }

        String key = relatePath2BucketKey(relativePath);
        try {
            s3Client.deleteObject(config.getS3RootBucketName(), key);
        } catch (Exception e) {
            throw new FileServiceException(
                    String.format("删除文件失败：relativePath:%s, key:%s", relativePath, key), e);
        }
        return true;
    }

    @Override
    public byte[] get(String relativePath) throws FileServiceException {

        if (relativePath == null || relativePath.isEmpty()) {
            throw new S3FileServiceException("relativePath为空");
        }

        String key = relatePath2BucketKey(relativePath);
        InputStream stream = s3Client.getStream(config.getS3RootBucketName(), key);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        int cnt;
        byte[] tmp = new byte[1024 * 100];
        try {
            while((cnt = stream.read(tmp)) != -1) {
                byteOut.write(tmp, 0, cnt);
            }
            return byteOut.toByteArray();
        } catch (Exception e) {
            throw new FileServiceException(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                // ignore
            }
            try{
                byteOut.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    @Override
    public boolean exist(String relativePath) throws FileServiceException {

        if (relativePath == null || relativePath.isEmpty()) {
            throw new S3FileServiceException("relativePath为空");
        }

        String key = relatePath2BucketKey(relativePath);
        byte[] bytes = s3Client.get(config.getS3RootBucketName(), key);
        return bytes == null || bytes.length == 0;
    }
}
