package com.progresspoint.patterns.structural_patterns.proxy;

public class RealSubject extends Subject {

    public RealSubject() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
