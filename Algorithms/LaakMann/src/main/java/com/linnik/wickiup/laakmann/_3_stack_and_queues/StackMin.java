package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.ArrayDeque;

/**
 * =================================================================================================
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * <p>
 * Example:
 * push(5); // stack is {5}, min is 5
 * push(6); // stack is {6, 5}, min is 5
 * push(3); // stack is {3, 6, 5}, min is 3
 * push(7); // stack is {7, 3, 6, 5}, min is 3
 * pop(); // pops 7. stack is {3, 6, 5}, min is 3
 * pop(); // pops 3. stack is {6, 5}. min is 5.
 * =================================================================================================
 */
public class StackMin extends ArrayDeque<StackMin.NodeWithMin> {

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE; // Error value
		} else {
			return peek().min;
		}
	}

	class NodeWithMin {
		int value;
		int min;

		NodeWithMin(int v, int min) {
			value = v;
			this.min = min;
		}
	}
}
