package edu.tjdz.blog.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tjdz.blog.beans.bean.Users;
import edu.tjdz.common.util.ResponseWriterUtil;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Resource(name = "getRedisTemplate")
    RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        ResultVO resultVO = new ResultVO(Code.UNAUTHORTIZED, "token过期", null);
        String token = req.getHeader("authentication");
        if(token == null || token == ""){
            chain.doFilter(req,response);
        }else{
            String obj = (String )redisTemplate.opsForValue().get(token);
            if(obj == null || obj == ""){
                System.out.println("obj == null || obj == ''");
                ResponseWriterUtil.write(resultVO,response);
            }else {
                ObjectMapper objectMapper = new ObjectMapper();
                Users users = objectMapper.readValue(obj, Users.class);
                String username = users.getUsername();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, null);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                doFilter(req,response,chain);
            }



        }







    }
}
