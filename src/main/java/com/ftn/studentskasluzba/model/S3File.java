package com.ftn.studentskasluzba.model;

import java.io.InputStream;

public record S3File(
        String bucket,
        String path,
        String contentType,
        Long contentLength,
        InputStream inputStream
) {
}
