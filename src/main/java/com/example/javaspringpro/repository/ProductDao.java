package com.example.javaspringpro.repository;


import com.example.javaspringpro.model.Product;
import com.example.javaspringpro.model.User;
import com.example.javaspringpro.service.UserService;
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
public class ProductDao {
    private final Connection connection;
    private final UserService userService;

    public ProductDao(DataSource ds, UserService userService) {
        try {
            this.connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.userService = userService;
    }

    public Product insert(String accountNumber, Integer balance, String productType, User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into products (account_number, balance, product_type, user_id) values (?, ?, ?, ?);" , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setInt(2, balance);
            preparedStatement.setString(3, productType);
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                return new Product(resultSet.getLong(1), accountNumber, balance, productType, user);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAllByUser(User user) {
        try {
            List<Product> products = new ArrayList<>();
            PreparedStatement preparedStatement =  connection.prepareStatement("select id, account_number, balance, product_type from products where user_id = ?;");
            preparedStatement.setLong(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(   3),
                        resultSet.getString(4),
                        user
                        ));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(Long id) {
        try {
            Product product = null;
            PreparedStatement preparedStatement = connection.prepareStatement("select account_number, balance, product_type, user_id from products where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product(id, resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        userService.findById(resultSet.getLong(4))
                );
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
