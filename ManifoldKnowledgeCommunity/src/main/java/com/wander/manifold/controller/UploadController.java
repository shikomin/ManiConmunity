package com.wander.manifold.controller;

import com.wander.core.utils.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 胥珂铭 on 2019/8/1.
 */
@RestController
@RequestMapping("/manifold")
public class UploadController {

    @PostMapping("/upload/image")
    @ResponseBody
    public String upload(@RequestParam("upload") MultipartFile upload) {
        if (upload.isEmpty()) {
            //return new ResponseEntity<String>("fail", HttpStatus.UNAUTHORIZED);
            return "fail";
        }
        String fileName = upload.getOriginalFilename();
        String filePath = "D:/GitHubRepository/repo5/ManifoldKnowledgeCommunity/src/main/webapp/upload-files/images/";
        File dest = new File(filePath + fileName);
        InputStream in=null;
        try {
            in=upload.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            //return new ResponseEntity<String>("fail", HttpStatus.UNAUTHORIZED);
            return "fail";
        }
        FileUtil.copyFile(in,dest);
        //因为ckedit的问题必须按下面格式的json字符串返回
        String returnPath="{\"uploaded\":1,\"url\":\"/upload-files/images/" + fileName+"\"}";
        //return new ResponseEntity<String>(returnPath, HttpStatus.OK);
        return returnPath;
    }


    @PostMapping("/upload/avatar")
    @ResponseBody
    public String uploadAvatar(@RequestParam("upload") MultipartFile upload) {
        if (upload.isEmpty()) {
            return "fail";
        }
        String fileName = upload.getOriginalFilename();
        String filePath = "D:/GitHubRepository/repo5/ManifoldKnowledgeCommunity/src/main/webapp/image/user_avatar/";
        File dest = new File(filePath + fileName);
        InputStream in=null;
        try {
            in=upload.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        FileUtil.copyFile(in,dest);
        String returnPath="{\"uploaded\":1,\"url\":\"/image/user_avatar/" + fileName+"\"}";
        return returnPath;
    }


}
