package com.bxbro.web.config.props;

public class FileServiceS3ConfigProps {

    private String accessKey;

    private String secretKey;

    private String endpoint;

    private String signingRegion;

    private String s3RootBucketName;

    private String pathSeperatorReplacor;

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
