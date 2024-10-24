package org.example.controller;

import org.example.dto.PaymentDto;
import org.example.dto.ProductDto;
import org.example.dto.ResponseDto;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = "/user/")
  public ResponseDto<ProductDto[]> getUserProducts(@RequestParam long id){
    return new ResponseDto<>(HttpStatus.OK.value(), productService.getUserProducts(id));
  }

  @GetMapping(value = "/execute")
  public ResponseDto<String> executeGet(@RequestParam long id, @RequestParam int amount){
    return new ResponseDto<>(productService.executeGet(id, amount).value(), "Processed");
  }

  @PostMapping(value = "/execute")
  public ResponseDto<String> executePost(@RequestBody PaymentDto paymentDto){
    return new ResponseDto<>(productService.executePost(paymentDto).value(), "Processed");
  }
}
