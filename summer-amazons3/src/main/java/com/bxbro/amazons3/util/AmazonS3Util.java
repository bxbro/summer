package com.bxbro.amazons3.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.bxbro.amazons3.config.RemoteConfig;

import java.util.List;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
public class AmazonS3Util {


    private static AmazonS3 s3 = null;

    public AmazonS3Util(RemoteConfig remoteConfig) {
        BasicAWSCredentials bac = new BasicAWSCredentials(remoteConfig.getAccesskey(), remoteConfig.getSecretkey());
        AWSStaticCredentialsProvider acp = new AWSStaticCredentialsProvider(bac);

        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(acp)
                .withChunkedEncodingDisabled(true)
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(remoteConfig.getEndpoint(), remoteConfig.getRegion()))
                .build();
    }


    public static List<Bucket> listBuckets() {
        List<Bucket> buckets = s3.listBuckets();
        return buckets;
    }

}
