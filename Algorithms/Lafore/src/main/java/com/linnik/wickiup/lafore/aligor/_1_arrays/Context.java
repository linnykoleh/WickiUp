package com.linnik.wickiup.lafore.aligor._1_arrays;


public class Context {

    public static void main(String[] args){

        OrdArray array = new OrdArray();
        //array.insertArray(new int[]{0,4,7,9,19,26,29,55,66});

        int pos = array.find(55);

        array.insert(20);
        array.insert(5);
        array.insert(49);
        array.insert(4);
        array.insert(45);
        array.insert(77);

        array.delete(45);

        int k = array.getKeyMaxValue();

        System.out.println(k);

    }
}
