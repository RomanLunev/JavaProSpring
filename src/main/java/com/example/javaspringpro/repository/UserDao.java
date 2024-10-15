package com.example.javaspringpro.repository;


import com.example.javaspringpro.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class UserDao {
    private final Connection connection;

    public UserDao(DataSource ds) {
        try {
            this.connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User insert(String userName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(username) values (?);" , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                return new User(resultSet.getLong(1), userName);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateById(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set username = ? where id = ?;");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = connection.prepareStatement("select id, username from users").executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(Long id) {
        try {
            User user = null;
            PreparedStatement preparedStatement = connection.prepareStatement("select id, username from users where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong(1), resultSet.getString(2));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
