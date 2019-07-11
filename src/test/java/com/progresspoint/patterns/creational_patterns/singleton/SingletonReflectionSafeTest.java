package com.progresspoint.patterns.creational_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class SingletonReflectionSafeTest {

    @Test
    void singletonSimple_twoVariablesDeclaredWithSingleton_shallReturnEqualObjects()  {

        SingletonReflectionSafe simpleEdek = SingletonReflectionSafe.getInstance("Edek");
        SingletonReflectionSafe simpleKarol = SingletonReflectionSafe.getInstance("Karol");

        System.out.println(simpleEdek.toString());
        System.out.println(simpleKarol.toString());

        assertEquals(simpleEdek, simpleKarol);
    }

    @Test
    void singletonSimple_twoVariablesDeclaredWithSingletonAndReflection_shallReturnNotEqualObjects() {

        SingletonReflectionSafe simpleEdek = SingletonReflectionSafe.getInstance("Edek");

        assertThrows(InvocationTargetException.class, SingletonReflectionSafeTest::execute);
    }

    private static void execute()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonReflectionSafe simpleKarol = null;
        Class constrArgument = String.class;
        Constructor<SingletonReflectionSafe> constructor =
                SingletonReflectionSafe.class.getDeclaredConstructor(constrArgument);
        constructor.setAccessible(true);
        simpleKarol = constructor.newInstance("Karol");
    }

}