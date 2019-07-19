package com.progresspoint.patterns;

import com.progresspoint.patterns.creational_patterns.factory.CurrencyFactory;
import com.progresspoint.patterns.creational_patterns.factory.CurrencyFunctionalFactory;
import com.progresspoint.patterns.creational_patterns.singleton.SingletonSimple;
import com.progresspoint.patterns.structural_patterns.proxy.Proxy;
import com.progresspoint.patterns.structural_patterns.proxy.SomeOtherThing;

import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {
        // Singleton simple demo
        System.out.println("\nSINGLETON\n");
        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        System.out.println("Singleton instance will create Edek : " + simpleEdek.getGreetings());

        SingletonSimple simpleKarol = SingletonSimple.getInstance("Karol");
        System.out.println("But hen we want to create Karol, this doesnt work :  " + simpleKarol.getGreetings());


        System.out.println("\nFACTORY\n");
        CurrencyFactory currencyFactory = new CurrencyFactory();
        String euroSymbol = currencyFactory.getCurrency("Euro").showSymbolOfCurrency();
        System.out.println("We had currency factory to get this symbol -> " + euroSymbol);

        Supplier<CurrencyFunctionalFactory> currencyFunctionalFactorySupplier = CurrencyFunctionalFactory::new;
        String dollarSymbol = currencyFunctionalFactorySupplier.get().getCurrency("Dollar").showSymbolOfCurrency();
        System.out.println("We had currency factory with map to get this symbol -> " + dollarSymbol);

        // PROXY DEMO
        System.out.println("\nPROXY\n");
        Proxy proxy = new Proxy();
        SomeOtherThing someOtherThing = new SomeOtherThing();
        someOtherThing.sayHeloo();
        proxy.sayHello();

    }
}
