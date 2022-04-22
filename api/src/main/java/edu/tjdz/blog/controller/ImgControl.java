package edu.tjdz.blog.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/img")
public class ImgControl {

    @Value("${blog.file.pathLocal}")
    String rootPath;
    @Value("${blog.file.pathPattern}")
    String pathPattern;

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file", required = true) MultipartFile multipartFile, String dir){
        System.out.println(dir);
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        String suffixs[] = originalFilename.split("\\.");
        String suffix = suffixs[suffixs.length-1];
        String newFileName = UUID.randomUUID().toString().replaceAll("-","")+"."+suffix;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String datePath = simpleDateFormat.format(new Date());

        File targetPath = new File(rootPath + dir, datePath);
        if(!targetPath.exists())targetPath.mkdirs();

        File targetFileName = new File(targetPath, newFileName);
        try {
            multipartFile.transferTo(targetFileName);
            String pathContext = pathPattern.split("/")[1];
            String urlReturn ="http://localhost:8080/"+pathContext+"/"+dir+"/"+datePath+"/"+newFileName;
            System.out.println(urlReturn);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("success",1);
            map.put("message","成功");
            map.put("url",urlReturn);
         return  new ObjectMapper().writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
