package com.progresspoint.patterns.creational_patterns.factory;

import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {

        System.out.println("\nFACTORY\n");

        // Currency Factory Kit
        CurrencyFactoryKit factoryKit = CurrencyFactoryKit.factory(currencyBuilder -> {
            currencyBuilder.add(CurrencyType.DOLLAR, Dollar::new);
            currencyBuilder.add(CurrencyType.EURO, Euro::new);
        });
        Currency dollar = factoryKit.create(CurrencyType.DOLLAR);
        System.out.println("We had factory kit to return symbol of dollar -> " + dollar.showSymbolOfCurrency());


        // Currency Factory

        CurrencyFactory currencyFactory = new CurrencyFactory();
        String euroSymbol = currencyFactory.getCurrency("Euro").showSymbolOfCurrency();
        System.out.println("We had currency factory to get euro symbol -> " + euroSymbol);

        // Currency Functional Factory
        Supplier<CurrencyFunctionalFactory> currencyFunctionalFactorySupplier = CurrencyFunctionalFactory::new;
        String dollarSymbol = currencyFunctionalFactorySupplier.get().getCurrency("Dollar").showSymbolOfCurrency();
        System.out.println("We had currency factory with map to get dollar symbol -> " + dollarSymbol);

    }
}
