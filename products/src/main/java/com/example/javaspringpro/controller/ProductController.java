package com.example.javaspringpro.controller;

import com.example.javaspringpro.exception.ProductNotFoundException;
import com.example.javaspringpro.entity.Product;
import com.example.javaspringpro.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = "/{id}")
  public Product getProductById(@PathVariable Long id) {
    Product product = productService.findById(id);
    if (product == null) {
      throw new ProductNotFoundException(id);
    }
    return productService.findById(id);
  }

}
