package com.codingtest.exchangerate.service;

import com.codingtest.exchangerate.config.OpenApiProperty;
import com.codingtest.exchangerate.controller.dto.CalculationRequest;
import com.codingtest.exchangerate.controller.dto.ExchangeRateResponse;
import com.codingtest.exchangerate.enums.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;

@RequiredArgsConstructor
@Service
public class ExchangeRateService {

    private final WebClient webClient;
    private final OpenApiProperty openApiProperty;

    public ExchangeRateResponse getExchangeRate(Currency currency) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("access_key", openApiProperty.getServiceKey());
        queryParams.add("currencies", currency.value());

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParams(queryParams)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class)
                .flatMap(response -> Mono.just(new ExchangeRateResponse(response, currency)))
                .block();
    }

    public String calculation(CalculationRequest param) {
        Double result = param.getExchangeRate() * param.getAmounts();
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        return String.format("수취금액은 %s %s 입니다.", formatter.format(result), param.getCurrency().value());
    }

}
