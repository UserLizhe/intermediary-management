package com.example.intermediarymanagementboot.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalControllerPathConfig implements WebMvcConfigurer {
    @Value("${spring.api-prefix:/api}") // 可在配置文件中自定义
    private String apiPrefix;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(apiPrefix, c -> c.isAnnotationPresent(RestController.class));
    }
}
