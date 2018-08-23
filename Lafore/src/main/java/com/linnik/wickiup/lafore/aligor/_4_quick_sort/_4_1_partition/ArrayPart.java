package com.linnik.wickiup.lafore.aligor._4_quick_sort._4_1_partition;


import java.util.Arrays;

public class ArrayPart {

    private int[] arr;
    private int size;
    private int defaultSize;

    public ArrayPart(int defaultSize) {
        this.defaultSize = defaultSize;
        this.arr = new int[defaultSize];
    }

    public void insert(final int value){
        if(size >= defaultSize){
            throw new IllegalStateException("Enough");
        }
        arr[size] = value;
        size++;
    }

    public void show(){
        System.out.println();
        Arrays.stream(arr).forEach(value -> System.out.print(" " + value));
        System.out.println();
    }

    private void swap(final int index1, final int index2){
        final int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public int partitionIt(int pivot){

        int leftPtr = 0 - 1;
        int rightPrt = size;
        while(true){
            while(arr[++leftPtr] < pivot);  //на каждой итерации находим элемент, который БОЛЬШЕ pivot
            while(arr[--rightPrt] > pivot); //На каждой итерации находим элемент, который МЕНЬШЕ pivot

            if (leftPtr >= rightPrt){
                break;
            }else{
                swap(leftPtr, rightPrt);
            }
        }
        return leftPtr;
    }

}
