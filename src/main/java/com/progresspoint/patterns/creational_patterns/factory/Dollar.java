package com.progresspoint.patterns.creational_patterns.factory;

public class Dollar implements Currency {
    @Override
    public String showSymbolOfCurrency() {
        return "$";
    }
}
