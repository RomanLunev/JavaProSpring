package com.example.javaspringpro.controller;

import com.example.javaspringpro.dto.ErrorDto;
import com.example.javaspringpro.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
  @ExceptionHandler(ProductNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto errorDto(ProductNotFoundException e) {
    return new ErrorDto(e.getMessage());
  }
}