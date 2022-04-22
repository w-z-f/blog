package edu.tjdz.blog.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MoblieAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MoblieAuthenticationToken authenticationToken = (MoblieAuthenticationToken) authentication;

        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if(userDetails == null){
            throw new UsernameNotFoundException("手机号未注册");
        }else if(!userDetails.isEnabled()){
            throw new DisabledException("该用户已被禁用");
        }

        MoblieAuthenticationToken resultToken = new MoblieAuthenticationToken(userDetails.getAuthorities(), userDetails.getUsername());
        resultToken.setDetails(authenticationToken.getDetails());
        return resultToken;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MoblieAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


}
