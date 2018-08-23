package com.linnik.wickiup.lafore.aligor._2_simple_sort.check_chapter;


public class ArraysAlgors {


    public static void main(String ... args){
        //TEST
    }

    public static void bubbleSort(int[] arr){
        if(arr == null){
            throw new NullPointerException();
        }
        int out, in;
        for(out = 0; out < arr.length-1; out++){
            for(in = 0; in < arr.length-1; in++){
                int next = arr[in+1];
                if(next < arr[in]){
                    arr[in+1] = arr[in];
                    arr[in] = next;
                }
            }
        }
    }

    public static void selectSort(int[] arr){
        if(arr == null){
            throw new NullPointerException();
        }
        int out, in;
        for(out = 0; out < arr.length; out++){
            int min = arr[out];
            for(in = out + 1; in < arr.length; in++){
                if(arr[in] < min){
                    min = arr[in];

                    int tmp = arr[in];
                    arr[in] = arr[out];
                    arr[out] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] arr){
        for(int key = 1; key < arr.length; key++){
            int tmp = arr[key];
            while(key > 0 && arr[key - 1] > tmp){
                arr[key] = arr[key - 1];
                key--;
            }
            arr[key] = tmp;
        }
    }
}
