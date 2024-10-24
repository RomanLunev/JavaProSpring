package com.example.javaspringpro.controller;

import com.example.javaspringpro.dto.PaymentDto;
import com.example.javaspringpro.entity.Product;
import com.example.javaspringpro.exception.ProductNotFoundException;
import com.example.javaspringpro.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    return product;
  }


  @GetMapping(value = "/user/{id}")
  public List<Product> getProductsByUserId(@PathVariable Long id) {
    List<Product> product = productService.findByUserId(id);
    return product;
  }

  @GetMapping(value = "/execute/{id}")
  public Product executeGet(@PathVariable Long id, @RequestParam int amount) {
    Product product = productService.execute(id, amount);
    return product;
  }

  @PostMapping(value = "/execute")
  public Product executePost(@RequestBody PaymentDto paymentDto) {
    return productService.execute(paymentDto.id(), paymentDto.amount());
  }
}
