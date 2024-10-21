package org.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integration.service")
public record  IntegrationServiceProperties (RestTemplateProperty products) {}
