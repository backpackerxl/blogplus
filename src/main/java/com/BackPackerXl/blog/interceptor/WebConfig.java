package com.BackPackerXl.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 21:45
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/admin/**")
        .excludePathPatterns("/admin")
        .excludePathPatterns("/admin/login");
    }
}
