package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.ArrayDeque;

/**
 * ===============================================================================================================
 * Queue via Stacks: Implement a class which implements a queue using two stacks.
 * <p>
 * Since the major difference between a queue and a stack is the order (first-in first-out vs. last-in first-out),
 * we know that we need to modify peek() and pop() to go in reverse order
 * ================================================================================================================
 */
public class QueueViaStack<T> {

	private ArrayDeque<T> stackNewest;
	private ArrayDeque<T> stackOldest;

	public QueueViaStack() {
		stackNewest = new ArrayDeque<>();
		stackOldest = new ArrayDeque<>();
	}

	public void add(T value) {
		/* Push onto stackNewest, which always has the newest elements on top */
		stackNewest.push(value);
	}

	public T peek() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek(); // retrieve the oldest item.
	}

	public T remove() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.pop(); // pop the oldest item.
	}

	/* Move elements from stackNewest into stackOldest. This is usually done so that
     we can do operations on stackOldest. */
	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
}
