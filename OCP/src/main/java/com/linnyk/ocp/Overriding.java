package com.linnyk.ocp;

import java.io.IOException;

public class Overriding {

    static class Parent {

        public Number doSomeWork() throws IOException{
            return 1;
        }
    }

    static class Child extends Parent {

//        public Number doSomeWork() throws IOException{ return 1; } Correct

//        public Number doSomeWork() throws FileNotFoundException{ return 1; } Correct

//        public Number doSomeWork() throws RuntimeException{ return 1; } Correct

//        public Number doSomeWork() { return 1;} Correct

//        public Integer doSomeWork() { return 1;} Correct

//        public Object doSomeWork() { return 1;}  NOT Correct

//        public Number doSomeWork() throws Exception{ return 1; } NOT Correct
    }
}
