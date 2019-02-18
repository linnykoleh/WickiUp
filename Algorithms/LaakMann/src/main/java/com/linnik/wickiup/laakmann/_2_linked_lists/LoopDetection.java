package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * <p>
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * <p>
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 *
 *  1 -> 2 -> 3 -> 4 -> 5 -> 6
 *  			   |	     |
 *  			  11		 7
 *  			   |		 |
 *  			  10 <- 9 <- 8
 */
public class LoopDetection {

	public Node findBeginning(Node head) {
		Node slow = head;
		Node fast = head;

		/* Find meeting point.*/
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // Collision
				break;
			}
		}

		/* Error check - no meeting point, and therefore no loop*/
		if (fast == null || fast.next == null) {
			return null;
		}

		 /* Move slow to Head.
		    Keep fast at Meeting Point.
		    Each are k steps from the Loop Start.
		    If they move at the same pace, they must meet at Loop Start. */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		/* Both now point to the start of the loop. */
		return fast;
	}

}
