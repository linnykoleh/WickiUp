package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class SortStackTest {

	@Test
	public void test() {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.addLast(1);
		stack.addLast(5);
		stack.addLast(10);
		stack.addLast(15);
		stack.addLast(2);
		stack.addLast(12);

		new SortStack().sort(stack);

		Assert.assertEquals("[1, 2, 5, 10, 12, 15]", stack.toString());
	}
}
