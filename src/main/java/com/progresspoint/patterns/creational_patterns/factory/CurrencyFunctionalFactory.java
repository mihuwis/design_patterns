package com.progresspoint.patterns.creational_patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CurrencyFunctionalFactory {

    final static Map<String, Supplier<Currency>> currencyMap = new HashMap<>();
    static {
        currencyMap.put("EURO", Euro::new);
        currencyMap.put("DOLLAR", Dollar::new);
    }

    public Currency getCurrency(String currency){
        Supplier<Currency> currencySupplier = currencyMap.get(currency.toUpperCase());
        if(currencySupplier != null) {
            return currencySupplier.get();
        }
        throw new IllegalArgumentException("No such currency: " + currency.toUpperCase());
    }
}
