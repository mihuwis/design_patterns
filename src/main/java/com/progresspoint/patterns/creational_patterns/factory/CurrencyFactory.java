package com.progresspoint.patterns.creational_patterns.factory;

public class CurrencyFactory {

    public Currency getCurrency(String currency) {
        if("Euro".equals(currency)){
            return new Euro();
        }
        return new Dollar();
    }
}
