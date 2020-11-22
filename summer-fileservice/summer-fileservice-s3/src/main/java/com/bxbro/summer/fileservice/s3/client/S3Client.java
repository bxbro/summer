package com.bxbro.summer.fileservice.s3.client;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.bxbro.summer.fileservice.s3.config.S3FileServiceConfig;
import com.bxbro.summer.fileservice.s3.exception.S3FileServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class S3Client {

    private static  final Logger logger = LoggerFactory.getLogger(S3Client.class);


    private AmazonS3 s3;

    private S3FileServiceConfig config;

    public AmazonS3 getS3() {
        return s3;
    }

    public S3FileServiceConfig getConfig() {
        return config;
    }

    public S3Client(S3FileServiceConfig config) {

        this.config = config;

        BasicAWSCredentials bac = new BasicAWSCredentials(config.getAccessKey(), config.getSecretKey());
        AWSStaticCredentialsProvider acp = new AWSStaticCredentialsProvider(bac);

        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(acp)
                .withChunkedEncodingDisabled(true)
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(config.getEndpoint(), config.getSigningRegion()))
                .build();
    }

    public List<Bucket> listBuckets() {
        List<Bucket> buckets = s3.listBuckets();
        return buckets;
    }

    public Bucket createBucket(String bucketName) {
        Bucket b = null;
        try {
            b = s3.createBucket(bucketName);
            return b;
        }catch (AmazonS3Exception e) {
            throw new S3FileServiceException("创建bucket异常", e);
        }
    }

    public boolean judgeBucketExist(String bucketName) {
        return s3.doesBucketExistV2(bucketName);
    }

    public void deleteBucket(String bucketName) {
        s3.deleteBucket(bucketName);
    }

    public void deleteObject(String bucketName, String keyName) {
        try {
            s3.deleteObject(bucketName, keyName);
        } catch (AmazonServiceException e) {
            throw new S3FileServiceException("删除对象异常", e);
        }
    }

    public List<S3ObjectSummary> listAllObjectOfBucket(String bucketName) {
        ObjectListing ol = s3.listObjects(bucketName);
        return ol.getObjectSummaries();
    }

    public void putString(String bucketName, String keyName, String str){
        try {
            s3.putObject(bucketName, keyName, str);
        } catch (Exception e) {
            throw  new S3FileServiceException("上传字符串异常", e);
        }
    }

    public void putObject(String bucketName, String keyName, String fileName) {
        try {
            s3.putObject(bucketName, keyName, new File(fileName));
        } catch (AmazonServiceException e) {
            throw  new S3FileServiceException("上传文件异常", e);
        }
    }

    public void putStream(String bucketName, String keyName, InputStream stream) {
        try {
            s3.putObject(bucketName, keyName,stream, new ObjectMetadata());
        } catch (AmazonServiceException e) {
            throw  new S3FileServiceException("存文件流异常", e);
        } finally {
            try{
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                // ignoew
            }
        }
    }

    public InputStream getStream(String bucketName, String keyName) {
        try{
            S3Object object = s3.getObject(bucketName, keyName);
            return object.getObjectContent();
        } catch (Exception e) {
            throw new S3FileServiceException("取文件流异常", e);
        }
    }

    public byte[] get(String bucketName, String keyName) {
        S3Object object = s3.getObject(bucketName, keyName);
        S3ObjectInputStream objectContent = object.getObjectContent();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int cnt;
        byte[] tmp = new byte[1024 * 10];
        try {
            while((cnt = objectContent.read(tmp)) != -1) {
                out.write(tmp, 0, cnt);
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw new S3FileServiceException("读取流发生异常",e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                // ignore
            }
            try{
                objectContent.close();
            }catch (IOException e) {
                // ignore
            }
        }
    }

}
