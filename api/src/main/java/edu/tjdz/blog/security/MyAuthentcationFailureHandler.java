package edu.tjdz.blog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tjdz.common.vo.*;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthentcationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("失败");
        response.setContentType("application/json;charset=utf-8");
        ResultVO resultVo = new ResultVO(Code.Fail, "登录失败", null);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(resultVo);
        PrintWriter writer = response.getWriter();
        writer.write(str);
        writer.flush();
        writer.close();


    }
}
