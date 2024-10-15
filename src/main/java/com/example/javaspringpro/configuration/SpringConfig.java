package com.example.javaspringpro.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean public DataSource datasource() {
        HikariConfig config = new  HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/javaPro");
        config.setUsername("pg");
        config.setPassword("123");
        config.setMaximumPoolSize(5);
        return new HikariDataSource( config );
    }
}
