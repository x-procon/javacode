package com.hazer.controller;

import com.hazer.model.ResultModel;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件相关
 *
 * @author hazer
 * Created on 2021/1/20
 */
@RestController
@RequestMapping("/file")
public class FileController  {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    /**  文件根路径*/
    @Value("${anychat.file.root}")
    private String fileRootPath;
    /**
     * 多文件上传
     * @param files 文件列表
     * @return 文件存储地址map
     */
    @RequiresRoles("admin")
    @PostMapping(value = "/upload")
    public ResultModel<Map<String, String>> fileUpload(@RequestParam("files") MultipartFile[] files){
        String filePath;
        // 多文件上传
        Map<String, String> map = new HashMap<>(16);
        for (MultipartFile file : files){
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            // 存储路径
            filePath = fileRootPath + originalFilename;
            try {
                // 保存文件
                file.transferTo(new File(filePath));
                map.put(originalFilename,filePath);
            } catch (IOException e) {
               log.error(e.getMessage(),e);
               return ResultModel.fail(e.getMessage());
            }
        }
        return ResultModel.ok(map);
    }

}
