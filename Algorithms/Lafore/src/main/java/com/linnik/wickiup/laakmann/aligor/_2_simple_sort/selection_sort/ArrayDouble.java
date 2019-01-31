package com.linnik.wickiup.laakmann.aligor._2_simple_sort.selection_sort;


public class ArrayDouble {

    private int arr[];
    private int size;

    public ArrayDouble(int max) {
        arr = new int[max];
        size = 0;
    }

    public void insert(int v){
        arr[size++] = v;
    }

    public void sortSelection(){
        for(int i = 0; i < size; i++){
            int min = arr[i];
            for(int j = i; j < size; j++){
               if(arr[j] < min){
                   int tmp = arr[j];
                   arr[j] = min;
                   arr[i] = tmp;

                   min = arr[j];
               }
            }
        }
    }

    public void sortSelection_2(){
        int out, in, min;
        for(out = 0; out < size; out++){
            min = out;
            for(in = out + 1; in < size; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
                swap(out, min);
            }
        }
    }

    private void swap(int keyElem1, int keyElem2){
        int tmp = arr[keyElem1];
        arr[keyElem1] = keyElem2;
        arr[keyElem2] = tmp;
    }

    public void display(){
        System.out.println();
        for(int v : arr){
            System.out.print(" ");
            System.out.print(v);
        }
        System.out.println();
    }


}
