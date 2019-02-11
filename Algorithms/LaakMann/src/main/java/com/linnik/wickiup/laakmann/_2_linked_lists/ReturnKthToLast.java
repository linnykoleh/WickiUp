package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ===================================================================================================
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * ===================================================================================================
 */
public class ReturnKthToLast {

    /**
     * Recursive solutions takes 0(n) space due to the recursive calls.
     */
    public int printKthToLast(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index <= k) {
            System.out.println(k + "th to last node is " + head.value);
        }
        return index;
    }

    /**
     * This algorithm takes O(n) time and 0(1) space.
     */
    public Node nthTolast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        /* Move p1 k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null; // Out of bounds
            }
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end, p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
