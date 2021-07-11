package com.codingtest.exchangerate.controller.dto;

import com.codingtest.exchangerate.enums.Currency;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalculationRequest {

    @ApiModelProperty(value = "환율", required = true)
    private Double exchangeRate;

    @ApiModelProperty(value = "통화", required = true)
    private Currency currency;

    @ApiModelProperty(value = "금액", required = true)
    private int amounts;

}
