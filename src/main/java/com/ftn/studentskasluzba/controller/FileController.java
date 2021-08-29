package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.service.S3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    S3Client s3Client;

    @GetMapping
    public ResponseEntity<InputStreamResource> getFile(@RequestParam("path") String path) {
        return s3Client
                .getFile(path)
                .map(s3File -> {
                    var inputStreamResource = new InputStreamResource(s3File.inputStream());
                    return ResponseEntity
                            .ok()
                            .contentType(MediaType.parseMediaType(s3File.contentType()))
                            .contentLength(s3File.contentLength())
                            .body(inputStreamResource);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
