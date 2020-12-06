package com.bxbro.summer.web.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "summer.file-service")
public class FileServiceConfigProps {

    public static final String SERVICE_TYPE_LOCAL = "local";
    public static final String SERVICE_TYPE_S3 = "s3";

    private String serviceType;
    private String resUrlPrefix;
    private String contextPath;


    private FileServiceS3ConfigProps s3;
    private FileServiceLocalConfigProps local;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getResUrlPrefix() {
        return resUrlPrefix;
    }

    public void setResUrlPrefix(String resUrlPrefix) {
        this.resUrlPrefix = resUrlPrefix;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public FileServiceS3ConfigProps getS3() {
        return s3;
    }

    public void setS3(FileServiceS3ConfigProps s3) {
        this.s3 = s3;
    }

    public FileServiceLocalConfigProps getLocal() {
        return local;
    }

    public void setLocal(FileServiceLocalConfigProps local) {
        this.local = local;
    }
}
