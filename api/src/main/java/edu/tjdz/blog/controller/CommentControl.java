package edu.tjdz.blog.controller;

import edu.tjdz.blog.beans.bean.Comment;
import edu.tjdz.blog.service.CommentService;
import edu.tjdz.common.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("comment")
@Api(tags = "评论接口",value = "评论接口")
public class CommentControl {

    @Autowired
    CommentService commentService;

    @ApiOperation("添加评论")
    @PostMapping("/add")
    public ResultVO addComment(@RequestBody Comment comment){

        return commentService.commentCommit(comment);
    }
}
