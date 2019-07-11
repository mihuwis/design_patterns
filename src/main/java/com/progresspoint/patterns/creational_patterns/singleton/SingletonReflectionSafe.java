package com.progresspoint.patterns.creational_patterns.singleton;

public class SingletonReflectionSafe {

    private static SingletonReflectionSafe singletonReflectionSafe;
    private String name;

    private SingletonReflectionSafe(String name) {
        if(singletonReflectionSafe != null){
            throw new IllegalStateException("There is already instance of this class");
        }
        this.name = name;
    }

    public static SingletonReflectionSafe getInstance(String name){
        if(singletonReflectionSafe == null){
            singletonReflectionSafe = new SingletonReflectionSafe(name);
        }
        return singletonReflectionSafe;
    }

    public String getGreetings(){
        return "Hello " + this.name + " here!";
    }

    @Override
    public String toString(){
        return "name: " + this.name;
    }
}
