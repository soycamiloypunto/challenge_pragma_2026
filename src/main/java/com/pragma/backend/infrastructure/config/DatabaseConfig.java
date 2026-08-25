package com.pragma.backend.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DatabaseConfig {
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}