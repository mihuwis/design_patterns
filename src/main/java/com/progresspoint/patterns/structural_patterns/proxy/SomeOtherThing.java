package com.progresspoint.patterns.structural_patterns.proxy;

import java.util.Date;

public class SomeOtherThing {

    public void sayHeloo(){
        System.out.println(this.getClass().getSimpleName() +" here! Im working :) Is " + new Date());
    }
}
