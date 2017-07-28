package com.linnik.wickiup.lafore.data_structures.linked_lists.doubly_linked_list;

/**
 * @author LinnykOleh
 */
public class DoublyLinkedApp {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertFirst(22);
        doublyLinkedList.insertFirst(44);
        doublyLinkedList.insertFirst(66);

        doublyLinkedList.insertLast(11);
        doublyLinkedList.insertLast(33);
        doublyLinkedList.insertLast(55);

        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();

        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteLast();
        doublyLinkedList.deleteKey(11);

        doublyLinkedList.displayForward();

        doublyLinkedList.insertAfter(22, 77);
        doublyLinkedList.insertAfter(33, 88);

        doublyLinkedList.displayForward();
    }
}
