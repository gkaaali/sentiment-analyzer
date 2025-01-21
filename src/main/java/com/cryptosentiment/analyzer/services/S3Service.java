package com.cryptosentiment.analyzer.services;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Path;

@Service
public class S3Service {

    private final S3Client s3Client = S3Client.create();

    public void uploadFile(String bucketName, String key, Path filePath) {
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build(),
                filePath
        );
    }
}
