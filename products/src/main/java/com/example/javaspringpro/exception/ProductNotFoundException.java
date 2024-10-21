package com.example.javaspringpro.exception;

public class ProductNotFoundException extends RuntimeException {
  private final String message;
  public ProductNotFoundException(Long id){
    message = "Product Not Found id: " + id;
  }

  public String getMessage() {
    return message;
  }
}
