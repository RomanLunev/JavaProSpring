package org.example.exceptions;

public class ProductResponseException extends RuntimeException {

  public ProductResponseException(String message) {
    super("Received from product service: " +  message);
  }
}
