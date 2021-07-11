package com.codingtest.exchangerate.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "openapi")
@Getter
@Setter
@ToString
public class OpenApiProperty {

    private String baseUrl;
    private String serviceKey;

}
