package edu.tjdz.blog.filter;

import edu.tjdz.blog.dao.UsersMapper;
import edu.tjdz.common.util.ResponseWriterUtil;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CodeValidcateFilter extends OncePerRequestFilter {

    @Resource(name="getRedisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    UsersMapper usersMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if ("/codelogin".equalsIgnoreCase(uri) && "post".equalsIgnoreCase(req.getMethod())){
            String formcode = req.getParameter("code");
            String phone = req.getParameter("phone");
            String redisCode = ""+redisTemplate.opsForValue().get(phone);
            if (formcode.equalsIgnoreCase(redisCode)){
                filterChain.doFilter(req,res);
            }else {
                ResponseWriterUtil.write(new ResultVO(Code.Fail,"验证码错误",null),res);
            }
        }else{
            filterChain.doFilter(req,res);
        }

    }
}
