package com.progresspoint.patterns.creational_patterns.factory;

public class CurrencyFactory {

    /**
     *
     * @param  currency representing type of currency to be created
     * @return new instance of requested class implementing {@link Currency} interface
     */
    public Currency getCurrency(String currency) {
        if("Euro".equals(currency)){
            return new Euro();
        } else if("Dollar".equals(currency)){
            return new Dollar();

        }
        throw new IllegalArgumentException("I don't have this currency");
    }
}
