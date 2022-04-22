package edu.tjdz.blog.mobile;

import edu.tjdz.blog.beans.bean.Uri;
import edu.tjdz.blog.beans.bean.Users;
import edu.tjdz.blog.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MobileUserDetails implements UserDetailsService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersMapper.getUserByPhoneNum(username);
        List<Uri> uris = user.getRole().getUris();
        ArrayList<String> anthentication = new ArrayList<>();
        for (Uri uri : uris) {
            anthentication.add(uri.getUri());
        }
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",anthentication)));
        return user;
    }
}
