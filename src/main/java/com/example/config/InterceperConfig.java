package com.example.config;

import com.example.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;

@Configuration
public class InterceperConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LogInterceptor() {
        });
        //如下的路径不拦截，多个路径用逗号分隔
        interceptorRegistration.excludePathPatterns("/demo/test2");
        //拦截如下路径
        interceptorRegistration.addPathPatterns("/**");
    }
}