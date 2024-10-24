package org.example.service;

import org.example.dto.PaymentDto;
import org.example.dto.ProductDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

  private final RestTemplate restTemplate;

  public ProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ProductDto[] getUserProducts(long userId) {
    return restTemplate.getForObject("/product/user/" + userId, ProductDto[].class);
  }

  public HttpStatusCode executeGet(long id, int amount) {
    ResponseEntity<ProductDto> entity =  restTemplate.getForEntity("/product/execute/" + id + "?amount="+amount, ProductDto.class);
    return entity.getStatusCode();
  }

  public HttpStatusCode executePost(PaymentDto paymentDto) {
    ResponseEntity<ProductDto> entity =  restTemplate.postForEntity("/product/execute", paymentDto, ProductDto.class);
    return entity.getStatusCode();
  }

}
