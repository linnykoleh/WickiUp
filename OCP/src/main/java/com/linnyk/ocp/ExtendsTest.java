package com.linnyk.ocp;

class B {}
class B1 extends B {}
class B2 extends B {}

public class ExtendsTest {

    public static void main(String[] args) {
        B b = new B();
        B1 b1 = new B1();
        B2 b2 = new B2();

        b1 = (B1) b;
        // Exception in thread "main" java.lang.ClassCastException: com.linnyk.ocp.B
        //              cannot be cast to com.linnyk.ocp.B1
    }
}