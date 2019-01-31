package com.linnik.wickiup.laakmann.aligor._2_simple_sort.selection_sort;



public class SelectionContext {

    public static void main(String[] args){

        ArrayDouble arrayDouble = new ArrayDouble(10);

        arrayDouble.insert(3);
        arrayDouble.insert(34);
        arrayDouble.insert(54);
        arrayDouble.insert(2);
        arrayDouble.insert(31);

        arrayDouble.insert(25);
        arrayDouble.insert(78);
        arrayDouble.insert(24);
        arrayDouble.insert(5);
        arrayDouble.insert(1);

        arrayDouble.display();

        arrayDouble.sortSelection();
        arrayDouble.display();
    }
}
