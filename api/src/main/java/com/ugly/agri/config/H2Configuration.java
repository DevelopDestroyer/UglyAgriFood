package com.ugly.agri.config;

import com.ugly.agri.service.InitService;
import lombok.RequiredArgsConstructor;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.sql.SQLException;

@Configuration
@Profile("local")
@RequiredArgsConstructor
public class H2Configuration {
    private final InitService initService;

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

    @Bean
    public void setTestData() throws IOException {
        initService.setTestData();
    }
}