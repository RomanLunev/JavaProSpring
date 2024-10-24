package com.example.javaspringpro.service;

import com.example.javaspringpro.entity.Product;
import com.example.javaspringpro.exception.ProductInsufficientBalanceException;
import com.example.javaspringpro.exception.ProductNotFoundException;
import com.example.javaspringpro.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
    }

    public List<Product> findByUserId(Long id) {
        return productRepository.findByUserId(id);
    }

    public Product execute(Long id, int amount) {
        Product product =  productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        if (product.getBalance() < amount) {
            throw new ProductInsufficientBalanceException(id);
        }
        product.setBalance(product.getBalance() - amount);
        productRepository.save(product);
        return product;
    }
}
