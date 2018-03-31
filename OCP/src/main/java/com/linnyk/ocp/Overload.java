package com.linnyk.ocp;

import java.io.IOException;

public class Overload {

    public int methodA(int a) throws Exception {
        return a * 2;
    }

    public int methodA(int a, int b) throws IOException{
        return a * 2;
    }

    public int methodA(int a, long b) {
        return a * 2;
    }

//    public long methodA(int a){ return a; } Compilation error. No method with signature

//    public long methodA(int a, long b){ return a; } Compilation error. No method with signature

}
