package com.progresspoint.patterns;

import com.progresspoint.patterns.creational_patterns.factory.CurrencyFunctionalFactory;
import com.progresspoint.patterns.creational_patterns.singleton.SingletonSimple;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        // Singleton simple
        System.out.println("\nSINGLETON\n");
        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        System.out.println("Singleton instance will create Edek : " + simpleEdek.getGreetings());

        SingletonSimple simpleKarol = SingletonSimple.getInstance("Karol");
        System.out.println("But hen we want to create Karol, this doesnt work :  " + simpleKarol.getGreetings());


        System.out.println("\nFACTORY\n");
        Supplier<CurrencyFunctionalFactory> currencyFactory = CurrencyFunctionalFactory::new;

        // Get Symbol of dollar
        String dollsarSymbol = currencyFactory.get().getCurrency("Dollar").showSymbolOfCurrency();

        System.out.println("We had currency factory to get this symbol -> " + dollsarSymbol);




    }
}
