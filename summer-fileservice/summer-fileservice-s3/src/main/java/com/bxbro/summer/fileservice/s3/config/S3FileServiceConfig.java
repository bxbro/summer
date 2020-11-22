package com.bxbro.summer.fileservice.s3.config;

public class S3FileServiceConfig {

    private String accessKey;

    private String secretKey;

    private String endpoint;

    private String signingRegion;

    private String s3RootBucketName;

    private String pathSeperatorReplacor;


    public S3FileServiceConfig(String accessKey,
                               String secretKey,
                               String endpoint,
                               String signingRegion,
                               String s3RootBucketName,
                               String pathSeperatorReplacor) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.endpoint = endpoint;
        this.signingRegion = signingRegion;
        this.s3RootBucketName = s3RootBucketName;
        this.pathSeperatorReplacor = pathSeperatorReplacor;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getSigningRegion() {
        return signingRegion;
    }

    public void setSigningRegion(String signingRegion) {
        this.signingRegion = signingRegion;
    }

    public String getS3RootBucketName() {
        return s3RootBucketName;
    }

    public void setS3RootBucketName(String s3RootBucketName) {
        this.s3RootBucketName = s3RootBucketName;
    }

    public String getPathSeperatorReplacor() {
        return pathSeperatorReplacor;
    }

    public void setPathSeperatorReplacor(String pathSeperatorReplacor) {
        this.pathSeperatorReplacor = pathSeperatorReplacor;
    }
}
