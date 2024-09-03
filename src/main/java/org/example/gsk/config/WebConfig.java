package org.example.gsk.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(new EmployeeInterceptor ()).addPathPatterns("/**").excludePathPatterns("*/login");
    }
}
