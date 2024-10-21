package org.example.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({IntegrationServiceProperties.class})
public class SpringConfiguration {
  private final static Logger log = LoggerFactory.getLogger(SpringConfiguration.class);
  @Bean
  public RestTemplate restTemplate(IntegrationServiceProperties RestTemplateProperty,
                                   ProductRestTemplateResponseErrorHandler errorHandler) {
    RestTemplateProperty products = RestTemplateProperty.products();
    log.info("Building RestTemplate bean");
    return new RestTemplateBuilder()
            .rootUri(products.uri())
            .setConnectTimeout(products.connectTimeout())
            .setReadTimeout(products.readTimeout())
            .errorHandler(errorHandler)
            .build();
  }
}
