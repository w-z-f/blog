package edu.tjdz.blog.controller;


import edu.tjdz.blog.code.Sms;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.ReverbType;

@RestController
@CrossOrigin
public class UsersConttrol  {

    @Autowired
    Sms sms;

    @PostMapping("/login")
    public ResultVO test1(){
       return null;
    }

    @PostMapping("/codelogin")
    public ResultVO test2(){

        return new ResultVO(Code.Fail,"test2",null);
    }

    @GetMapping("/send")
    public ResultVO sendSms(String phone){
        int i = sms.sendSms(phone);
        return new ResultVO(i,null,null);
    }

    @GetMapping("/index")
    public ResultVO index(){
        return new ResultVO(Code.SUCCESS,null,null);
    }





}
