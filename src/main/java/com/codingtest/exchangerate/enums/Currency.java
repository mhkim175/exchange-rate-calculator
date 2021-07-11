package com.codingtest.exchangerate.enums;

public enum Currency {

    KRW("KRW", "USDKRW"),

    JPY("JPY", "USDJPY"),

    PHP("PHP", "USDPHP");

    private final String value;

    private final String usdValue;

    Currency(String value, String usdValue) {
        this.value = value;
        this.usdValue = usdValue;
    }

    public String value() {
        return value;
    }

    public String usdValue() {
        return usdValue;
    }

}
