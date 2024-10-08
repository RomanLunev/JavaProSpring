package org.example.exercise4;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DataSource {
    private final HikariDataSource ds;

    private DataSource(HikariConfig config) {
        ds = new HikariDataSource( config );
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}