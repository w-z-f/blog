package edu.tjdz.blog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tjdz.blog.beans.bean.Users;
import edu.tjdz.blog.dao.UsersMapper;
import edu.tjdz.blog.util.JwtUtils;
import edu.tjdz.common.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UsersMapper mapper;

    @Resource(name = "getRedisTemplate")
    RedisTemplate redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("成功");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        Users user = null;
        if(username == null || username == ""){
            username = request.getParameter("phone");
             user = mapper.getUserByPhoneNum(username);
        }else {
             user = mapper.getUserByUsername(username);
        }
        String token = jwtUtils.generateToken(username);
        int expire = jwtUtils.getExpire();
        ObjectMapper objectMapper = new ObjectMapper();
        String userStr = objectMapper.writeValueAsString(user);
        //返回token给用户
        response.addHeader(jwtUtils.getHeader(),token);
        //解决跨域导致前端获取不到token的问题
        response.setHeader("Access-Control-Expose-Headers","Authentication");
        redisTemplate.opsForValue().set(token,userStr,expire, TimeUnit.SECONDS);
        ResultVO resultVO = new ResultVO(Code.SUCCESS, "登陆成功", user);
        String str = objectMapper.writeValueAsString(resultVO);
        PrintWriter writer = response.getWriter();
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
