package org.example.controller;

import org.example.dto.ProductErrorDto;
import org.example.exceptions.ProductNotEnoughBalance;
import org.example.exceptions.ProductResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductRestControllerAdvice {
  @ExceptionHandler({ProductResponseException.class, ProductNotEnoughBalance.class})
  public ProductErrorDto handleException(Exception ex){
    return new ProductErrorDto(ex.getMessage());
  }
}
