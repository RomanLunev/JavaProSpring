package com.example.javaspringpro.controller;

import com.example.javaspringpro.model.Product;
import com.example.javaspringpro.service.ProductService;
import com.example.javaspringpro.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/product")
public class ProductController {
  private final ProductService productService;
  private final UserService userService;

  public ProductController(ProductService productService, UserService userService) {
    this.productService = productService;
    this.userService = userService;
  }

  @GetMapping(value = "/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productService.findById(id);
  }

  @GetMapping(value = "/user/{id}")
  public List<Product> getAllProducts(@PathVariable Long id) {
    return productService.findAllByUser(userService.findById(id));
  }
}
