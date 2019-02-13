package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ========================================================================================================
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * <p>
 * EXAMPLE
 * <p>
 * Input:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 * =========================================================================================================
 */
public class DeleteMiddleNode {

	public boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		Node next = n.next;
		n.value = next.value;
		n.next = next.next;
		return true;
	}
}
