package org.example.exceptions;

public class ProductNotEnoughBalance extends RuntimeException {
  public ProductNotEnoughBalance(String message) {
    super(message);
  }
}
