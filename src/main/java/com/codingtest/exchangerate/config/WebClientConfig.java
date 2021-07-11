package com.codingtest.exchangerate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(OpenApiProperty openApiProperty) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(openApiProperty.getBaseUrl());
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);

        return WebClient.builder().uriBuilderFactory(factory)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
