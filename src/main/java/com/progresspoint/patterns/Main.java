package com.progresspoint.patterns;

import com.progresspoint.patterns.creational_patterns.singleton.SingletonSimple;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        // Singleton simple
        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        System.out.println("Singleton instance will create Edek : " + simpleEdek.getGreetings());

        SingletonSimple simpleKarol = SingletonSimple.getInstance("Karol");
        System.out.println("But hen we want to create Karol, this doesnt work :  " + simpleKarol.getGreetings());





    }
}
