package com.linnyk.ocp;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeExample {

    public static void main(String[] args) {
        Path p1 = Paths.get("x/y");
        Path p2 = Paths.get("z");
        Path p3 = p1.relativize(p2);
        System.out.println(p3); //..\..\z

        /*
           x\\y то же самое что и x/y
         */
    }
}
