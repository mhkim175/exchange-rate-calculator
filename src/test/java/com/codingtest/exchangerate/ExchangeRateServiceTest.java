package com.codingtest.exchangerate;

import com.codingtest.exchangerate.controller.dto.CalculationRequest;
import com.codingtest.exchangerate.enums.Currency;
import com.codingtest.exchangerate.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class ExchangeRateServiceTest {

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @BeforeEach
    void setUp() {
    }

    @DisplayName(value = "환율 계산")
    @Test
    void calculation() {
        // given
        CalculationRequest calculationRequest = new CalculationRequest();
        calculationRequest.setExchangeRate(1233.31);
        calculationRequest.setCurrency(Currency.KRW);
        calculationRequest.setAmounts(100);

        //when
        String result = exchangeRateService.calculation(calculationRequest);

        // then
        assertThat(result).isNotEmpty();

        log.info("calculation: {}", result);
    }

}
