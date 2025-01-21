package com.cryptosentiment.analyzer.controllers;

import com.cryptosentiment.analyzer.services.S3Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam String bucket, @RequestParam String key, @RequestParam String filePath) {
        s3Service.uploadFile(bucket, key, Path.of(filePath));
        return "File uploaded to S3 successfully!";
    }
}
