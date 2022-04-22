package edu.tjdz.blog.controller;


import edu.tjdz.blog.service.BlogService;
import edu.tjdz.common.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/blog")
@Api(value = "博客管理",tags = "博客管理")
public class BlogControl {

    @Autowired
    BlogService blogService;

    @ApiOperation("查询博客列表")
    @GetMapping("/list")
    public ResultVO listAllBlog(int page,int limit,String title,String type,Integer recommended){
       return blogService.listAllBlog(page,limit,title,type,recommended);
    }

    @ApiOperation("添加博客接口")
    @PostMapping("/add")
    public ResultVO addBlog(String title, @RequestBody HashMap<String,Object> map, String articleImg,
                            int userId, int source, String typeId,
                            int recommended, int reward, int info, int isComment,
                            int commentId, int viewNum, int published){
        Date creTime = new Date();
        String content =(String) map.get("content");
        String tagsId = (String) map.get("tagsId");
        System.out.println(content);
        System.out.println(tagsId);
        return  blogService.addBlog(title,content,articleImg,userId,source,typeId,tagsId,recommended,reward,info,isComment,commentId,viewNum,creTime,new Date(),published);
    }

    @GetMapping("/get")
    public ResultVO getBlog(Integer blogId){
        System.out.println("blog/get");
     return    blogService.getBlog(blogId);
    }





}
