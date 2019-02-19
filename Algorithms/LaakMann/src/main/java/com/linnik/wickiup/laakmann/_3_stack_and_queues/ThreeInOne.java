package com.linnik.wickiup.laakmann._3_stack_and_queues;

import com.linnik.wickiup.laakmann._3_stack_and_queues.exceptions.EmptyStackException;
import com.linnik.wickiup.laakmann._3_stack_and_queues.exceptions.FullStackException;

/**
 * ==========================================================================================================
 * Three in One: Describe how you could use a single array to implement three stacks.
 * <p>
 * We can divide the array in three equal parts and allow the individual stack to grow in that limited space.
 * Note: We will use the notation "[" to mean inclusive of an end point and "(" to mean exclusive of an end
 * point.
 * <p>
 * For stack 1, we will use [0, n/3).
 * For stack 2, we will use [n/3, 2n/3).
 * For stack 3, we will use [2n/3, n).
 * ============================================================================================================
 */
public class ThreeInOne {

	private final int numberOfStacks = 3;

	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public ThreeInOne(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	/* Push value onto stack. */
	public void push(int stackNumber, int value) throws FullStackException {
		/* Check that we have space for the next element */
		if (isFull(stackNumber)) {
			throw new FullStackException();
		}

		/* Increment stack pointer and then update top value. */
		sizes[stackNumber]++;
		values[indexOfTop(stackNumber)] = value;
	}

	/* Removes and get the top item from top stack. */
	public int pop(int stackNumber) {
		if (isEmpty(stackNumber)) {
			throw new EmptyStackException();
		}

		int topIndex = indexOfTop(stackNumber);
		int value = values[topIndex]; // Get top
		values[topIndex] = 0; // Clear
		sizes[stackNumber]--; // Shrink
		return value;
	}

	/* Return top element. */
	public int peek(int stackNumber) {
		if (isEmpty(stackNumber)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNumber)];
	}

	/* Return if stack is empty. */
	private boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	/* Return if stack is full. */
	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	/* Returns index of the top of the stack. */
	private int indexOfTop(int stackNumber) {
		int offset = stackNumber * stackCapacity;
		int size = sizes[stackNumber];
		return offset + size - 1;
	}

}
