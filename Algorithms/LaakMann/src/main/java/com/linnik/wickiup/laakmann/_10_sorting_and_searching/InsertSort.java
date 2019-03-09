package com.linnik.wickiup.laakmann._10_sorting_and_searching;

public class InsertSort {

    /**
     * Time: 0(n2) Memory: 0(1)
     */
    public void sort(int[] array) {
        int in, out;
        for (out = 1; out < array.length; out++) {    // out - разделительный маркер
            int temp = array[out];                    // Скопировать помеченный элемент
            in = out;                                 // Начать перемещения с out
            while (in > 0 && array[in - 1] >= temp) { // Пока не найден меньший элемент
                array[in] = array[in - 1];            // Сдвинуть элемент вправо
                --in;                                 // Перейти на одну позицию влево
            }
            array[in] = temp;                         // Вставить помеченный элемент
        }
    }
}
