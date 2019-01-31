package com.linnik.wickiup.laakmann.aligor._2_simple_sort.insert_sort;

/**
 * Created by ������ on 26.03.2016.
 */
public class InsertContext {

    public static void main(String ... args){

        ArrayInsert arrayInsert = new ArrayInsert(10);

        arrayInsert.insert(4);
        arrayInsert.insert(44);
        arrayInsert.insert(48);
        arrayInsert.insert(41);
        arrayInsert.insert(34);
        arrayInsert.insert(7);
        arrayInsert.insert(9);
        arrayInsert.insert(1);

        arrayInsert.display();

        arrayInsert.insertSort();

        arrayInsert.display();



    }
}
