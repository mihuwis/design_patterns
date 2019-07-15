package com.progresspoint.patterns.structural_patterns.proxy;

import java.util.Date;

public class RealSubject implements Subject {

    public RealSubject() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() + " says hello at " + new Date());
    }
}
