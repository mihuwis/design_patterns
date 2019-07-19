package com.progresspoint.patterns;


import com.progresspoint.patterns.creational_patterns.singleton.SingletonSimple;
import com.progresspoint.patterns.structural_patterns.proxy.Proxy;
import com.progresspoint.patterns.structural_patterns.proxy.SomeOtherThing;


public class Main {


    public static void main(String[] args) {
        // Singleton simple demo
        System.out.println("\nSINGLETON\n");
        SingletonSimple simpleEdek = SingletonSimple.getInstance("Edek");
        System.out.println("Singleton instance will create Edek : " + simpleEdek.getGreetings());

        SingletonSimple simpleKarol = SingletonSimple.getInstance("Karol");
        System.out.println("But hen we want to create Karol, this doesnt work :  " + simpleKarol.getGreetings());




        // PROXY DEMO
        System.out.println("\nPROXY\n");
        Proxy proxy = new Proxy();
        SomeOtherThing someOtherThing = new SomeOtherThing();
        someOtherThing.sayHeloo();
        proxy.sayHello();

    }
}
