package com.ugly.agri.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${resources.location}")
    private String resourcesLocation;

    @Value("${resources.uri_path}")
    private String resourcesUriPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*");
    }

    @SneakyThrows
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        resourcesLocation = ResourceUtils.getFile(resourcesLocation).getAbsolutePath();
        log.info("resourcesLocation = {}", resourcesLocation);
        registry.addResourceHandler(resourcesUriPath + "/**")
                .addResourceLocations("file://" + resourcesLocation + "/");
    }
}