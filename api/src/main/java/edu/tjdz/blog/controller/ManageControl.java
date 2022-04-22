package edu.tjdz.blog.controller;


import edu.tjdz.blog.beans.bean.Article;
import edu.tjdz.blog.beans.bean.Blog;
import edu.tjdz.blog.service.BlogService;
import edu.tjdz.common.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "后台管理接口",tags = "后台管理接口")
@CrossOrigin
@RequestMapping("/manage")
public class ManageControl  {

    @Autowired
    BlogService blogService;

    @ApiOperation("博客列表查询接口")
    @GetMapping("/list")
    public ResultVO list(){
        System.out.println("list");

        return null;
    }

    @ApiOperation("按条件查询博客列表")
    @GetMapping("/search")
    public ResultVO search(){
        return null;
    }

        @ApiOperation("删除博客")
        @PostMapping("/delete")
        public ResultVO deleteBlog(Integer blogId){
            return blogService.deleteBlog(blogId);
        }

        @PostMapping("/update")
    public ResultVO updateBlog(@RequestBody Blog blog, @RequestBody Article article){
        return blogService.updateBlog(blog,article);
        }


    }









