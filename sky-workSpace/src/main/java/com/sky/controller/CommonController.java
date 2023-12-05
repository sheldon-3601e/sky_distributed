package com.sky.controller;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName CommonController
 * @Author 26483
 * @Date 2023/11/10 17:45
 * @Version 1.0
 * @Description 通用接口模块
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口模块")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Result<String> upload(MultipartFile file) {
        log.info("上传文件：{}",file);

        try {

            //获取文件的原始名字
            String originalFilename = file.getOriginalFilename();
            //获取文件名字的后缀
            if (originalFilename != null) {
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                //拼接成新的名字
                String ObjectName = UUID.randomUUID().toString() + extension;
                //文件上传
                String upload = aliOssUtil.upload(file.getBytes(), ObjectName);
                return Result.success(upload);
            }

        } catch (IOException e) {
            log.error("文件上传失败:{}", e.getMessage());
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
