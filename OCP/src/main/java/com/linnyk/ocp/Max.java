package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;

public class Max {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);

        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); // 9
        System.out.println(ls.stream().max((a1, b1) -> Integer.max(a1, b1)).get()); // 3
        System.out.println(ls.stream().max((x, y) -> Integer.compare(x, y)).get()); // 9
        System.out.println(ls.stream().max((a, b)->a>b?a:b)); // Optional[3]
    }
}
