package com.linnik.wickiup.laakmann.algorithms.bubble_sort;

/**
 * @author LinnykOleh
 */
public class BubbleSortApp {

    public static void main(String[] args) {

        final ArrayBubble arrayBubble = new ArrayBubble(10);

        arrayBubble.insert(6);
        arrayBubble.insert(1);
        arrayBubble.insert(7);
        arrayBubble.insert(3);
        arrayBubble.insert(54);
        arrayBubble.insert(82);
        arrayBubble.insert(2);
        arrayBubble.insert(9);
        arrayBubble.insert(11);
        arrayBubble.insert(20);

        arrayBubble.display();

        arrayBubble.sort();

        arrayBubble.display();
    }
}
