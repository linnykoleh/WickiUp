package com.linnik.wickiup.laakmann.aligor._2_simple_sort.bubble_sort;


public class ArrayFirst {

    private int[] a;
    private int size;

    public ArrayFirst(int max) {
        this.a = new int[max];
        size = 0;
    }

    public void insert(int value){
        a[size] = value;
        size++;
    }

    public void bubbleSort(){
        for(int i = a.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j + 1]){
                    swap(j, j + 1);
                }
            }
        }
    }

    public void bubbleSort2() {
        for(int i = 0; i < size - 1 ; i++){
            for(int j = 0; j < size - 1; j++){
                if(a[j] > a[j + 1]){
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int keyElem1, int keyElem2){
        int tmp = a[keyElem1];
        a[keyElem1] = keyElem2;
        a[keyElem2] = tmp;
    }

    public void display(){
        System.out.println();
        for(int v : a){
            System.out.print(" ");
            System.out.print(v);
        }
        System.out.println();
    }

}
