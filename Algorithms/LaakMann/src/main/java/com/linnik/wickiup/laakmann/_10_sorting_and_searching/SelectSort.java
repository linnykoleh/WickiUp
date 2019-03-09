package com.linnik.wickiup.laakmann._10_sorting_and_searching;

public class SelectSort {

    /**
     * Time: 0(n2) Memory: 0(1)
     */
    public void sort(int[] array) {
        for (int out = 0; out < array.length; out++) {
            int min = out;
            for(int in = out + 1; in < array.length; in++){
                if(array[in] < array[min]){
                    min = in;
                }
            }
            swap(array, out, min);
        }
    }

    private void swap(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
