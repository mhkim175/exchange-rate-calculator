package com.codingtest.exchangerate.controller;

import com.codingtest.exchangerate.controller.dto.ExchangeRateResponse;
import com.codingtest.exchangerate.enums.Currency;
import com.codingtest.exchangerate.service.ExchangeRateService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Api(tags = {"환율 계산기"})
@RequestMapping("/calculator")
@RequiredArgsConstructor
@RestController
public class CalculatorController {

    private final ExchangeRateService exchangeRateRequestService;

    @GetMapping
    public ModelAndView calculator(ModelAndView mav) {
        ExchangeRateResponse exchangeRateDto = exchangeRateRequestService.getExchangeRate(Currency.KRW);
        mav.addObject("data", exchangeRateDto);
        mav.setViewName("calculator");
        return mav;
    }
    
}
