package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

/**
 * ====================================================================================================
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 * <p>
 * To approach this problem, we can picture a palindrome like 0 - > 1 - > 2 - > 1 - > 0. We know that,
 * since it's a palindrome, the list must be the same backwards and forwards.
 * ====================================================================================================
 */
public class Palindrome {

	public boolean isPalindrome(Node<Integer> head) {
		Node<Integer> reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	private Node<Integer> reverseAndClone(Node<Integer> node) {
		Node<Integer> head = null;
		while (node != null) {
			Node<Integer> clone = new Node<>(node.value); // Clone
			clone.next = head;
			head = clone;
			node = node.next;
		}
		return head;
	}

	private boolean isEqual(Node<Integer> one, Node<Integer> two) {
		while (one != null && two != null) {
			if (one.value != two.value) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
}
