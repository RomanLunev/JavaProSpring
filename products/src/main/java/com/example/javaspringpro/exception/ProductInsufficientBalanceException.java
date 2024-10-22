package com.example.javaspringpro.exception;

public class ProductInsufficientBalanceException extends RuntimeException {
  private final String message;
  public ProductInsufficientBalanceException(Long id){
    message = "Product  id: " + id + " has insufficient balance";
  }

  public String getMessage() {
    return message;
  }
}
