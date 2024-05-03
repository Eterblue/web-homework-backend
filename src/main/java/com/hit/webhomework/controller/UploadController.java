package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.service.impl.OssUploadServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class UploadController {
    @Autowired
    private OssUploadServiceImpl uploadService;

    @PostMapping("/upload")
    public ResponseResult uploadImg(@NotNull MultipartFile img){
        return uploadService.uploadImg(img);
    }
}