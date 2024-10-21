package org.example.service;

import org.example.exceptions.ProductNotEnoughBalance;
import org.example.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

  private final RestTemplate restTemplate;

  public ProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ProductDto getProduct(int id) {
    ProductDto productDto =  restTemplate.getForObject("/product/" + id, ProductDto.class);
    if (productDto != null && productDto.balance() <= 0 ) {
      throw new ProductNotEnoughBalance("Not enough balance for productDto id: " + id);
    }
    return productDto;

  }
}
