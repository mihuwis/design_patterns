package com.progresspoint.patterns.creational_patterns.singleton;

public class SingletonThreadSafe {

    public static SingletonThreadSafe instance;

    private SingletonThreadSafe(){

    }

    //Thread 100% safe
    public static SingletonThreadSafe getInstance(){
        if(instance == null){
            synchronized (SingletonThreadSafe.class) {
                if(instance == null){
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }

    //Thread ~95%% safe
//    public static SingletonThreadSafe getInstance(){
//        if(instance == null){
//            synchronized (SingletonThreadSafe.class) {
//
//                    instance = new SingletonThreadSafe();
//                }
//
//        }
//        return instance;
//    }


}
