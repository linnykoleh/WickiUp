package com.linnik.wickiup.lafore.algorithms.selection_sort;

/**
 * @author LinnykOleh
 */
public class SelectionSortApp {

    public static void main(String[] args) {
        final ArraySelection array = new ArraySelection(10);

        array.insert(2);
        array.insert(8);
        array.insert(1);
        array.insert(6);
        array.insert(5);
        array.insert(10);
        array.insert(3);
        array.insert(4);
        array.insert(7);
        array.insert(9);

        array.display();

        array.sort();

        array.display();
    }
}
