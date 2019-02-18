package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ==============================================================================================================
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 * <p>
 * Example
 * Here is a picture of intersecting linked lists:
 *
 * 3 -> 1 -> 5 -> 9
 * 					\
 *                    7 -> 2 -> 1
 *					/
 *           4 -> 6
 *
 * And here is a picture of non-intersecting linked lists:
 *
 * 3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1
 *
 * 		     4 -> 6 -> 7 -> 2 -> 2
 *
 * <p>
 * Determining if there's an intersection.
 * How would we detect if two linked lists intersect? One approach would be to use a hash table and just
 * throw all the linked lists nodes into there. We would need to be careful to reference the linked lists by their
 * memory location, not by their value.
 * There's an easier way though. Observe that two intersecting linked lists will always have the same last node.
 * Therefore, we can just traverse to the end of each linked list and compare the last nodes.
 * ================================================================================================================
 */
public class Intersection {

	class Result {
		Node tail;
		int size;

		Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	/**
	 * This algorithm takes O(A + B) time, where A and Bare the lengths of the two linked lists. It takes O(1)additional space.
	 */
	public Node findIntersection(Node list1, Node list2) {
		if (list1 == null || list2 == null) {
			return null;
		}

		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);

		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}

		/* Set pointers to the start of each linked list. */
		Node shorter = result1.size < result2.size ? list1 : list2;
		Node longer = result1.size < result2.size ? list2 : list1;

		/* Advance the pointer for the longer linked list by difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		/* Return either one. longer or shorter*/
		return longer;
	}

	private Result getTailAndSize(Node list) {
		if (list == null) {
			return null;
		}

		int size = 1;
		Node current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	private Node getKthNode(Node head, int k) {
		Node current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
}
