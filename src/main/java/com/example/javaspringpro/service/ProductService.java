package com.example.javaspringpro.service;

import com.example.javaspringpro.model.Product;
import com.example.javaspringpro.model.User;
import com.example.javaspringpro.repository.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product insert(String accountNumber, Integer balance, String productType, User user) {
        return productDao.insert(accountNumber, balance, productType, user);
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAllByUser(User user) {
        return productDao.findAllByUser(user);
    }

    public void deleteAll() {
        productDao.deleteAll();
    }
}
