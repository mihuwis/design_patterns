package com.progresspoint.patterns.structural_patterns.proxy;

import java.util.Date;

public class Proxy implements Subject {

    RealSubject realSubject;

    public Proxy(){
        System.out.println("Creating proxy at " + new Date());
    }

    @Override
    public void sayHello(){
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.sayHello();
    }
}
