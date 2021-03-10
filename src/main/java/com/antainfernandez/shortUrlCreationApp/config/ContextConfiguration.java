package com.antainfernandez.shortUrlCreationApp.config;

import com.antainfernandez.shortUrlCreationApp.service.Base26AlphabetOnlyConverter;
import com.antainfernandez.shortUrlCreationApp.service.UrlConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ContextConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public UrlConverter urlConverter() {
        return new Base26AlphabetOnlyConverter();
    }
}
