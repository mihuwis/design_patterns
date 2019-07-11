package com.progresspoint.patterns.creational_patterns.singleton;

public class SingletonSimple {

    private static SingletonSimple singletonSimple = null;
    private String name;

    private SingletonSimple(String name){
        this.name = name;
    }

    public static SingletonSimple getInstance(String name){
        if(singletonSimple == null) {
            singletonSimple = new SingletonSimple(name);
        }
        return singletonSimple;
    }

    public String getGreetings(){
        return "Hello " + this.name + " here!";
    }

    @Override
    public String toString(){
        return "name: " + this.name;
    }
}
