package com.progresspoint.patterns.creational_patterns.factory;

public class App {

    public static void main(String[] args) {

        CurrencyFactoryKit factoryKit = CurrencyFactoryKit.factory(currencyBuilder -> {
            currencyBuilder.add(CurrencyType.DOLLAR, Dollar::new);
            currencyBuilder.add(CurrencyType.EURO, Euro::new);
        });

        Currency dollar = factoryKit.create(CurrencyType.DOLLAR);

        System.out.println("Symbol od dollar is: " + dollar.showSymbolOfCurrency());

    }
}
