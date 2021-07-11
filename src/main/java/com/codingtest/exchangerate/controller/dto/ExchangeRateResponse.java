package com.codingtest.exchangerate.controller.dto;

import com.codingtest.exchangerate.enums.Currency;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.RepresentationModel;

import java.text.DecimalFormat;

@Getter
@Setter
@ToString
public class ExchangeRateResponse extends RepresentationModel<ExchangeRateResponse> {

    @ApiModelProperty(value = "환율")
    private String exchangeRate;

    @ApiModelProperty(value = "통화")
    private String currency;

    @ApiModelProperty(value = "데이터 요청 성공 여부")
    private boolean success;

    public ExchangeRateResponse(String response, Currency currency) {
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        this.success = jsonObject.get("success").getAsBoolean();

        if(success){
            JsonObject quotesObject = jsonObject.get("quotes").getAsJsonObject();
            DecimalFormat formatter = new DecimalFormat("###,###.##");
            this.exchangeRate = formatter.format(quotesObject.get(currency.usdValue()).getAsDouble());
            this.currency = currency.value();
        }

    }

}
