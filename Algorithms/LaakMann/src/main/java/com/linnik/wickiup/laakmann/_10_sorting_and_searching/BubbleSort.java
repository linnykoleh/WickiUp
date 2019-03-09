package com.linnik.wickiup.laakmann._10_sorting_and_searching;

public class BubbleSort {

    /**
     * Time : 0(n2) Memory: 0(1)
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
