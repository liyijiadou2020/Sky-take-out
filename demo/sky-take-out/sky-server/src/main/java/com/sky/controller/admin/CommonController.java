package com.sky.controller.admin;
import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
/**
 * 通用接口
 *
 * @author Li Yijia
 * @date 2024/4/12
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);
        // 原始文件名
        String originalFilename = file.getOriginalFilename();
        // 截取原始文件的后缀
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 构建新文件名称
        String objectName = UUID.randomUUID().toString() + extension;
        //  获得文件的请求路径
        String filepath = "";
        // filepath = aliOssUtil.upload(file.getBytes(), objectName);

        // TODO 目前直接使用随便一张图片来填充请求路径，目的只是实现回显功能
        filepath = "https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/images/20240408170526.png";
        return Result.success(filepath);

    }

}
