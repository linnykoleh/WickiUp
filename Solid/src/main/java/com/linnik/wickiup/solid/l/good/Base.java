package com.linnik.wickiup.solid.l.good;

/**
 * @author LinnykOleh
 */
public abstract class Base {

   abstract void print();
}

class PrinterChild{

    void print(Base base){
        base.print();
    }
}

class Child1 extends Base {
    @Override
    void print() {
        System.out.println("Child1");
    }
}

class Child2 extends Base {
    @Override
    void print() {
        System.out.println("Child2");
    }
}

class Child3 extends Base {
    @Override
    void print() {
        System.out.println("Child3");
    }
}

