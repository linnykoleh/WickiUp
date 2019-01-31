package com.linnik.wickiup.laakmann.algorithms.insertion_sort;

/**
 * @author LinnykOleh
 */
public class ArrayInsertion {

    private int[] array;
    private int arraySize;

    public ArrayInsertion(int arraySize) {
        this.array = new int[arraySize];
    }

    public void insert(int value){
        if(arraySize < array.length){
            array[arraySize] = value;
        }
        arraySize++;
    }

    public void sort() {
        int in, out;
        for(out = 1; out < array.length; out++) {    // out - разделительный маркер
            int temp = array[out];                   // Скопировать помеченный элемент
            in = out;                                // Начать перемещения с out
            while(in > 0 && array[in-1] >= temp){    // Пока не найден меньший элемент
                array[in] = array[in-1];             // Сдвинуть элемент вправо
                --in;                                // Перейти на одну позицию влево
            }
            array[in] = temp;                        // Вставить помеченный элемент
        }
    }

    public void display(){
        System.out.println();
        for(int v : array){
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
