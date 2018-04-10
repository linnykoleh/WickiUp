package com.linnyk.ocp.modifier_default.p1;

public class AA extends A {

    public void doIt(){
        System.out.println(new A().number); //OK
        System.out.println(number); //OK

        System.out.println(numberProt); //OK
        System.out.println(new A().numberProt); //OK
    }
}
