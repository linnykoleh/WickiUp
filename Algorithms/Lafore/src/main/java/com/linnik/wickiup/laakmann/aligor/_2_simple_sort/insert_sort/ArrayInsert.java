package com.linnik.wickiup.laakmann.aligor._2_simple_sort.insert_sort;


public class ArrayInsert {

    private int[] arr;
    private int size;

    public ArrayInsert(int max) {
        arr = new int[max];
    }

    public void insert(int v){
        arr[size] = v;
        size++;
    }

    public void insertSort(){
        int in, out;
        for(out = 1; out < size; out++){
            int tmp = arr[out];
            in = out;
            while (in > 0 && arr[in-1] >= tmp){
                arr[in] = arr[in-1];
                --in;
            }
            arr[in] = tmp;
        }
    }

    public void display(){
        System.out.println(" ");
        for(int v : arr){
            System.out.print(v);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
