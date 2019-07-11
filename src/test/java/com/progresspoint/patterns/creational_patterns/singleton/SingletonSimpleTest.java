package com.progresspoint.patterns.creational_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class SingletonSimpleTest {

    @Test
    void singletonSimple_twoVariablesDeclaredWithSingleton_shallReturnEqualObjects(){

        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        SingletonSimple simpleKarol = SingletonSimple.getInstance("Karol");

        System.out.println(simpleEdek.toString());
        System.out.println(simpleKarol.toString());

        assertEquals(simpleEdek, simpleKarol);
    }

    @Test
    void singletonSimple_twoVariablesDeclaredWithSingletonAndReflection_shallReturnNotEqualObjects(){
        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        SingletonSimple simpleKarol = null;
        try{
            Class constrArgument = String.class;
            Constructor<SingletonSimple> constructor = SingletonSimple.class.getDeclaredConstructor(constrArgument);
            constructor.setAccessible(true);
            simpleKarol= constructor.newInstance("Karol");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        assert simpleKarol != null;
        System.out.println(simpleKarol.toString());

        assertNotEquals(simpleEdek, simpleKarol);
    }



}