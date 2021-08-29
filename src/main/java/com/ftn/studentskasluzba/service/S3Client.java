package com.ftn.studentskasluzba.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ftn.studentskasluzba.model.S3File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.Optional;

@Service
public class S3Client {

    @Value("${s3.accessKey}")
    private String accessKey;

    @Value("${s3.secretKey}")
    private String secretKey;

    @Value("${s3.bucket}")
    private String bucket;

    private AmazonS3 client() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withRegion(Regions.EU_SOUTH_1)
                .build();
    }

    @PostConstruct
    private void init() {
        var client = client();
        if (!client.doesBucketExistV2(bucket))
            client.createBucket(bucket);
    }

    public String putFile(String path, InputStream inputStream) {
        client()
                .putObject(bucket, path, inputStream, new ObjectMetadata());
        return path;
    }

    public Boolean deleteFile(String path) {
        try {
            client().deleteObject(bucket, path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<S3File> getFile(String path) {
        try {
            var object = client()
                    .getObject(bucket, path);
            return Optional.of(
                    new S3File(
                            bucket,
                            path,
                            object.getObjectMetadata().getContentType(),
                            object.getObjectMetadata().getContentLength(),
                            object.getObjectContent()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
