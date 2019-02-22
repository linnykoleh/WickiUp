package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.ArrayDeque;

/**
 * ======================================================================================================
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 * ======================================================================================================
 */
public class SortStack {

	/**
	 * This algorithm is O (N2) time and O ( N) space.
	 */
	public void sort(ArrayDeque<Integer> firstStack) {
		ArrayDeque<Integer> secondStack = new ArrayDeque<>();

		while (!firstStack.isEmpty()) {

			/* Insert each element in firstStack in sorted order into secondStack. */
			Integer tmp = firstStack.pop(); // delete and return first element
			Integer peek = secondStack.peek(); // return but not remove first element
			while (!secondStack.isEmpty() && peek > tmp) {
				final Integer pop = secondStack.pop();  // delete and return first element
				firstStack.push(pop);
			}
			secondStack.push(tmp);
		}

		/* Copy the elements from secondStack back into firstStack. */
		while (!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());
		}
	}
}
