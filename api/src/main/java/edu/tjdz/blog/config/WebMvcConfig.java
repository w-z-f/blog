package edu.tjdz.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${blog.file.pathPattern}")
    String pathPattern;
    @Value("${blog.file.pathLocal}")
    String pathLocal;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        pathLocal = "file:"+pathLocal;
        registry.addResourceHandler(pathPattern).addResourceLocations(pathLocal);
    }
}
