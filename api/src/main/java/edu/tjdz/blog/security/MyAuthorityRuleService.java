package edu.tjdz.blog.security;

import edu.tjdz.blog.beans.bean.Uri;
import edu.tjdz.blog.beans.bean.Users;
import edu.tjdz.blog.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component("myRbacAuthention")
public class MyAuthorityRuleService  {

    @Autowired
    UsersMapper usersMapper;

    public boolean hasPermission(HttpServletRequest req , Authentication authentication){

        Object principal = authentication.getPrincipal();
        /*if(principal instanceof  UserDetails){
            System.out.println(req.getRequestURI());
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            System.out.println(authorities);
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(req.getRequestURI());
            return authorities.contains(simpleGrantedAuthority);
        }*/

        Users user = usersMapper.getUserByUsername((String) principal);
        List<Uri> uris = user.getRole().getUris();
        ArrayList<String> authUris = new ArrayList<>();
        for (Uri uri : uris) {
            authUris.add(uri.getUri());
        }
      return   authUris.contains(req.getRequestURI());



    }

}
