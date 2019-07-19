package com.progresspoint.patterns.creational_patterns.factory;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Functional interface
 * <br>Factory method is placeholder for {@link CurrencyBuilder}
 *
 */
public interface CurrencyFactoryKit {

    /**
     * Method to create an instance of currency type
     * @param name representing enum of type to be created
     * @return new instance of requested class implementing {@link Currency} interface.
     */
    Currency create(CurrencyType name);

    /**
     *
     */
    static CurrencyFactoryKit factory(Consumer<CurrencyBuilder> consumer) {
        Map<CurrencyType, Supplier<Currency>> map = new HashMap<>();
        consumer.accept(map::put);
        return name -> map.get(name).get();
    }

}
