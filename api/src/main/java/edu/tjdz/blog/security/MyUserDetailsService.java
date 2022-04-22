package edu.tjdz.blog.security;

import edu.tjdz.blog.beans.bean.Uri;
import edu.tjdz.blog.beans.bean.Users;
import edu.tjdz.blog.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersMapper.getUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String password = user.getPassword();
        String encode = passwordEncoder.encode(password);
        List<Uri> uris = user.getRole().getUris();
        ArrayList<String> authortiy = new ArrayList<>();
        for (Uri uri : uris) {
             authortiy.add(uri.getUri());
        }
        return new User(username,encode,AuthorityUtils.commaSeparatedStringToAuthorityList(
                String.join(",",authortiy)
        ));
    }





}
