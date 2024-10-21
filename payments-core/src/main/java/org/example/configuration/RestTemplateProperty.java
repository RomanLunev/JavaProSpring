package org.example.configuration;

import java.time.Duration;

public record RestTemplateProperty (String uri, Duration connectTimeout, Duration readTimeout) {}
