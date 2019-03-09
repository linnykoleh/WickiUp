package com.linnik.wickiup.laakmann._10_sorting_and_searching;

public class MergeSort {

    /**
     * Time: 0(n log(n)) Memory: 0(n)
     */
    public void sort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);           // Sort left half
            mergeSort(array, helper, middle + 1, high); // Sort right half
            merge(array, helper, low, middle, high);         // Merge them
        }
    }

    private void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array*/
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /* Iterate through helper array. Compare the left and right half, copying back
         * the smaller element from the two halves into the original array. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {//If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the target array*/
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
