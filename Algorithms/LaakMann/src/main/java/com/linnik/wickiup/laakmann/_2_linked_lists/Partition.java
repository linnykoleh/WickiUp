package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ==========================================================================================================
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * <p>
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * ===========================================================================================================
 */
public class Partition {

	public Node partition(Node<Integer> node, int partition) {
		Node<Integer> head = node;
		Node<Integer> tail = node;

		while (node != null) {
			Node<Integer> next = node.next;
			if (node.value < partition) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		// The head has changed, so we need to return it to the user.
		return head;
	}

}
