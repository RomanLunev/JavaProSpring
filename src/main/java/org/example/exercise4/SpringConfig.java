package org.example.exercise4;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean public HikariConfig hikariConfig() {
        HikariConfig config = new  HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/javaPro");
        config.setUsername("pg");
        config.setPassword("123");
        config.setMaximumPoolSize(5);
        return config;
    }
}
