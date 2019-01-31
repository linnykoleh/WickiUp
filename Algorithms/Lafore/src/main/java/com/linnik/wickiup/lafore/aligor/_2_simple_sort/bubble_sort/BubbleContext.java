package com.linnik.wickiup.lafore.aligor._2_simple_sort.bubble_sort;


public class BubbleContext {

    public static void main(String... args ){

        ArrayFirst arrayFirst = new ArrayFirst(10);

        arrayFirst.insert(3);
        arrayFirst.insert(34);
        arrayFirst.insert(54);
        arrayFirst.insert(2);
        arrayFirst.insert(31);

        arrayFirst.insert(25);
        arrayFirst.insert(78);
        arrayFirst.insert(24);
        arrayFirst.insert(5);
        arrayFirst.insert(1);

        arrayFirst.display();

//        arraySub.bubbleSort2();
        arrayFirst.bubbleSort();
        arrayFirst.display();

    }
}
