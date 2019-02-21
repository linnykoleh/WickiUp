package com.linnik.wickiup.laakmann._3_stack_and_queues.structures;

import lombok.ToString;

@ToString
public class Stack {

	private int capacity;
	private Node top;
	private Node bottom;
	public int size = 0;

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public void join(Node above, Node below) {
		if (below != null) {
			below.above = above;
		}
		if (above != null) {
			above.below = below;
		}
	}

	public boolean push(int v) {
		if (size >= capacity) {
			return false;
		}
		size++;
		Node n = new Node(v);
		if (size == 1) {
			bottom = n;
		}
		join(n, top);
		top = n;
		return true;

	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null) {
			bottom.below = null;
		}
		size--;
		return b.value;

	}

}
