package edu.tjdz.blog.controller;


import edu.tjdz.blog.service.TagService;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/tag")
public class TagControl {

    @Autowired
    TagService tagService;



   @GetMapping("/list")
    public ResultVO listTag(){
       return tagService.listTag();
   }

}
