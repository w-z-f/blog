package edu.tjdz.blog.security;

import edu.tjdz.common.util.ResponseWriterUtil;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("JwtAuthenticationEntryPoint");
       /* response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);*/
        ResponseWriterUtil.write(new ResultVO(Code.UNAUTHORTIZED,"没有登录",null),response);
    }
}
