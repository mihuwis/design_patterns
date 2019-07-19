package com.progresspoint.patterns.creational_patterns.factory;

import java.util.function.Supplier;

/**
 * Functional Interface
 * <br>This interface allows adding CurrencyBuilder with name to the FactoryKit
 */
public interface CurrencyBuilder {

    void add(CurrencyType name, Supplier<Currency> supplier);
}
