package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.ArrayList;
import java.util.List;

import com.linnik.wickiup.laakmann._3_stack_and_queues.exceptions.EmptyStackException;
import com.linnik.wickiup.laakmann._3_stack_and_queues.structures.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
 * (that is, pop () should return the same values as it would if there were just a single stack).
 */
public class StackOfPlates {

	private List<Stack> stacks = new ArrayList<>();

	private int capacity;

	public StackOfPlates(int capacity) {
		this.capacity = capacity;
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {//add to last stack
			last.push(v);
		} else {//must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		if (last == null) {
			throw new EmptyStackException();
		}
		int v = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return v;
	}

	private Stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}
}
