package edu.tjdz.blog.controller;

import edu.tjdz.blog.dao.UsersMapper;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/file")
@Api(value = "上传文件接口",tags = "上传文件接口")
public class UploadControl {

    @Value("${blog.file.pathLocal}")
    String rootPath;
    @Value("${blog.file.pathPattern}")
    String pathPattern;

    @Autowired
    UsersMapper usersMapper;

    @PostMapping("/upload")
    public ResultVO upload(MultipartFile multipartFile,String dir,int userId){
        String originalFilename = multipartFile.getOriginalFilename();
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
            String urlReturn = pathContext+dir+"/"+datePath+"/"+newFileName;
            System.out.println(urlReturn);
            usersMapper.updateAvatarUri(urlReturn,userId);
            return new ResultVO(Code.SUCCESS,"上传成功",urlReturn);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultVO(Code.Fail,"失败",null);
        }




    }

}
