package com.linnik.wickiup.laakmann._2_linked_lists.structures;

import java.util.Objects;

public class LinkedList<T> {

    Node<T> head;
    Node<T> tail;

    void append(T val) {
        Node<T> node = new Node<>(val);
        if (Objects.isNull(head)) {
            head = node;
        } else if (Objects.isNull(tail)) {
            tail = node;
            head.next = tail;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public String toString() {
        return head + "";
    }
}
