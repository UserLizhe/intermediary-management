package com.example.intermediarymanagementboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")   // 匹配所有路径
                .allowedOrigins("http://localhost:8081")  // 允许的请求源（可配置多个）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的 HTTP 方法
                .allowedHeaders("*")   // 允许所有请求头
                .allowCredentials(true)   // 允许携带凭证（如 Cookie）
                .maxAge(3600);   // 预检请求缓存时间（秒）
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");  // 允许所有来源[1,6](@ref)
        config.addAllowedHeader("*");         // 包含自定义Header
        config.addAllowedMethod("*");         // 必须包含OPTIONS方法[6](@ref)
        config.setAllowCredentials(true);     // 允许携带凭证

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
