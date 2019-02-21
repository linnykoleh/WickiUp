package com.linnik.wickiup.laakmann._3_stack_and_queues.structures;

public class Node {

	Node above;
	Node below;
	Integer value;

	public Node(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node{" +
				"above=" + above.value +
				", below=" + below.value +
				", value=" + value +
				'}';
	}
}
