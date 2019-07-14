package com.progresspoint.patterns.creational_patterns.factory;

public class Euro implements Currency {

    @Override
    public String showSymbolOfCurrency() {
        return "€";
    }
}
