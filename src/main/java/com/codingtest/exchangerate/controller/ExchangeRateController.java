package com.codingtest.exchangerate.controller;

import com.codingtest.exchangerate.controller.dto.CalculationRequest;
import com.codingtest.exchangerate.controller.dto.ExchangeRateResponse;
import com.codingtest.exchangerate.enums.Currency;
import com.codingtest.exchangerate.service.ExchangeRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Api(tags = {"환율 APIs"})
@RequestMapping("/api/exchangerate")
@RequiredArgsConstructor
@RestController
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateRequestService;

    @ApiOperation(value = "환율 조회")
    @GetMapping(value = "/{currency}")
    public ResponseEntity<ExchangeRateResponse> getExchangeRate(@PathVariable("currency") Currency currency) {
        return ResponseEntity.ok(
                exchangeRateRequestService.getExchangeRate(currency)
                        .add(linkTo(methodOn(ExchangeRateController.class).getExchangeRate(currency)).withSelfRel())
                        .add(linkTo(methodOn(ExchangeRateController.class).calculation(new CalculationRequest())).withSelfRel())
        );
    }

    @ApiOperation(value = "환율 계산")
    @PostMapping(value = "/calculation")
    public ResponseEntity<String> calculation(@RequestBody CalculationRequest param) {
        return ResponseEntity.ok(
                exchangeRateRequestService.calculation(param)
        );
    }
    
}
