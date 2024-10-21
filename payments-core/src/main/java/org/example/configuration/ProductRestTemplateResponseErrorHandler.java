package org.example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.ProductErrorDto;
import org.example.exceptions.ProductResponseException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class ProductRestTemplateResponseErrorHandler implements ResponseErrorHandler {
  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return response.getStatusCode().is4xxClientError()||response.getStatusCode().is5xxServerError();
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    ProductErrorDto productErrorDto = new ObjectMapper().readValue(response.getBody(), ProductErrorDto.class);
    throw new ProductResponseException(productErrorDto.message());
  }
}
