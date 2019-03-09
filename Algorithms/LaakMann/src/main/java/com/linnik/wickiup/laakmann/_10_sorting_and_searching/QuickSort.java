package com.linnik.wickiup.laakmann._10_sorting_and_searching;

public class QuickSort {

    /**
     * Time: 0(n log(n)) Memory: 0(log(n))
     */
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {// Sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) {// Sort right half
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick pivot point
        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) left++;

            // Find element on right that should be on left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);// swaps elements
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
