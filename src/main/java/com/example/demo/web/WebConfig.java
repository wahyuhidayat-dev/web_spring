package com.example.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    
    public void addViewController(ViewControllerRegistry viewControllerRegistry)
    {
        viewControllerRegistry.addViewController("/").setViewName("index");
        viewControllerRegistry.addViewController("/login");
        viewControllerRegistry.addViewController("/error/403").setViewName("/error/403");
    }
}
