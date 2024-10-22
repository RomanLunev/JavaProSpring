package org.example.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({IntegrationServiceProperties.class})
public class SpringConfiguration {
  @Bean
  public RestTemplate restTemplate(IntegrationServiceProperties RestTemplateProperty,
                                   ProductRestTemplateResponseErrorHandler errorHandler) {
    RestTemplateProperty products = RestTemplateProperty.products();
    return new RestTemplateBuilder()
            .rootUri(products.uri())
            .setConnectTimeout(products.connectTimeout())
            .setReadTimeout(products.readTimeout())
            .errorHandler(errorHandler)
            .build();
  }
}
