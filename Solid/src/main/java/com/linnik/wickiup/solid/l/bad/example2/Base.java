package com.linnik.wickiup.solid.l.bad.example2;

/**
 * @author LinnykOleh
 */
public class Base {}

class Child1 extends Base{}

class Child2 extends Base{}

class Child3 extends Base{}

class PrinterChild{

    void print(Base base){

        if(base instanceof Child1){
            System.out.println("Child1");
        } else if(base instanceof Child2){
            System.out.println("Child2");
        } else if(base  instanceof Child3){
            System.out.println("Child3");
        }
    }
}