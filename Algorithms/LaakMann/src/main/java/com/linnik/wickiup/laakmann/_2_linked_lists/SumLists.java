package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ====================================================================================================
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * ====================================================================================================
 */
public class SumLists {

    private class PartialSum {
        private Node<Integer> sum = null;
        private int carry = 0;
    }

    public Node addLists(Node<Integer> l1, Node<Integer> l2) {
        int lenl = length(l1);
        int len2 = length(l2);

        /* Pad the shorter list with zeros - see note (1) */
        if (lenl < len2) {
            l1 = padList(l1, len2 - lenl);
        } else {
            l2 = padList(l2, lenl - len2);
        }

        /* Add lists */
        PartialSum sum = addListsHelper(l1, l2);

        /* If there was a carry value left over, insert this at the front of the list.
        Otherwise, just return the linked list. */
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            Node<Integer> result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private PartialSum addListsHelper(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        /* Add smaller digits recursively*/
        PartialSum sum = addListsHelper(l1.next, l2.next);

        /* Add carry to current data*/
        int val = sum.carry + l1.value + l2.value;

        /* Insert sum of current digits*/
        Node<Integer> full_result = insertBefore(sum.sum, val % 10);

        /* Return sum so far, and the carry value*/
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    /* Pad the list with zeros*/
    private Node<Integer> padList(Node<Integer> l1, int padding) {
        Node<Integer> head = l1;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    /* Helper function to insert node in the front of a linked list*/
    private Node<Integer> insertBefore(Node<Integer> list, int data) {
        Node<Integer> node = new Node<>(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    private int length(Node<Integer> node) {
        return (node == null) ? 0 : length(node.next) + 1;
    }

}
