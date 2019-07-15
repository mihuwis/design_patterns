package com.progresspoint.patterns.structural_patterns.proxy;

import java.util.Date;

public abstract class Subject {

    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() + " says hello at " + new Date());
    }
}
