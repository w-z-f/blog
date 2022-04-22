package edu.tjdz.blog.config;


import edu.tjdz.blog.filter.CodeValidcateFilter;
import edu.tjdz.blog.filter.JwtAuthenticationFilter;
import edu.tjdz.blog.mobile.MobileAuthenticationFilter;
import edu.tjdz.blog.mobile.MobileUserDetails;
import edu.tjdz.blog.mobile.MoblieAuthenticationProvider;
import edu.tjdz.blog.security.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("#{'${blog.security.uri-authentication}'.split(',')}")
    private String[] URI_AUTHENTICATION ;



    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    MyAuthentcationFailureHandler myAuthentcationFailureHandler;

    @Autowired
    CodeValidcateFilter codeValidcateFilter;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    MobileUserDetails mobileUserDetails;

    @Resource(name="myRbacAuthention")
    MyAuthorityRuleService myRbacAuthention;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    JwtAccessDeniedHandler jwtAccessDeniedHandler;




    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter();
        mobileAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
        mobileAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        mobileAuthenticationFilter.setAuthenticationFailureHandler(myAuthentcationFailureHandler);
        http.addFilterBefore(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        http.cors().and().csrf().disable()

                .formLogin()
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthentcationFailureHandler)



                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers(URI_AUTHENTICATION).access("@myRbacAuthention.hasPermission(request,authentication)")
                .anyRequest().permitAll()

        .and()
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .accessDeniedHandler(jwtAccessDeniedHandler)


        ;
        http.headers().frameOptions().disable();


}
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new MyUserDetailsService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        MoblieAuthenticationProvider moblieAuthenticationProvider = new MoblieAuthenticationProvider();
        moblieAuthenticationProvider.setUserDetailsService(this.mobileUserDetails);
        auth.authenticationProvider(moblieAuthenticationProvider);
        auth .userDetailsService(getUserDetailsService());
}

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }



}
