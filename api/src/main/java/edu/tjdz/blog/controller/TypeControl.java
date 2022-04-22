package edu.tjdz.blog.controller;

import edu.tjdz.blog.service.TypeService;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class TypeControl {

    @Autowired
    TypeService typeService;

    @GetMapping("/list")
    public ResultVO listType(){
       return typeService.listType();
    }

}
