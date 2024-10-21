package com.example.javaspringpro.service;

import com.example.javaspringpro.entity.Product;
import com.example.javaspringpro.exception.ProductNotFoundException;
import com.example.javaspringpro.repository.ProductRepository;
import org.springframework.stereotype.Service;

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
}
