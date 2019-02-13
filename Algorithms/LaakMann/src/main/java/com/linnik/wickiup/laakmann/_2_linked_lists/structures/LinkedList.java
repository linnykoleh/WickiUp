package com.linnik.wickiup.laakmann._2_linked_lists.structures;

import java.util.Objects;

public class LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;

    public void append(T val) {
        Node<T> node = new Node<>(val);
        append(node);
    }

    public void appendAsNode(Node<T> node) {
        append(node);
    }

    private void append(Node<T> node) {
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
