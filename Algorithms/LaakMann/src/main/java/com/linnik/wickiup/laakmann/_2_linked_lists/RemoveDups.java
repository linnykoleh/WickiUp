package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

import java.util.HashSet;

/**
 * ===========================================================================
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * <p>
 * How would you solve this problem if a temporary buffer is not allowed?
 * ===========================================================================
 */
public class RemoveDups {

    /**
     * The solution takes O(N) time, where N is the number of elements in the linked list.
     */
    public <T> void deleteDups_1(Node<T> node) {
        HashSet<T> hashTable = new HashSet<>();

        Node cursor = null;
        while (node != null) {
            if (hashTable.contains(node.value)) {
                cursor.next = node.next;
            } else {
                hashTable.add(node.value);
                cursor = node;
            }
            node = node.next;
        }
    }

    /**
     * No Buffer Allowed
     * <p>
     * This code runs in O (1) space, but O (N2) time.
     */
    public <T> void deleteDups_2(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            /* Remove all future nodes that have the same value */
            Node<T> runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
