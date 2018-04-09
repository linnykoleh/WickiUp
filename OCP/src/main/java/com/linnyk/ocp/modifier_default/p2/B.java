package com.linnyk.ocp.modifier_default.p2;

import com.linnyk.ocp.modifier_default.p1.A;

public class B extends A{

    public void doIt(){
//        System.out.println(number);   Compilation error bcs of default
//        System.out.println(new A().number); Compilation error bcs of default
    }
}
