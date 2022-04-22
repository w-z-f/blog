package edu.tjdz.blog.security;

import edu.tjdz.common.util.ResponseWriterUtil;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        System.out.println("JwtAccessDeniedHandler");
        /*response.setStatus(HttpServletResponse.SC_FORBIDDEN);*/
        ResponseWriterUtil.write(new ResultVO(Code.UNAUTHENTICATION,"权限不足",null),response);

    }
}
