package com.linnyk.ocp;

public class InstanceOfExample {

    public static void main(String[] args) {
        B b = new B();
        System.out.println((b instanceof A) && !(b instanceof C));
    }

    static class A {}
    static class B extends A {}
    static class C extends B {}
    static class D extends C {}
}
