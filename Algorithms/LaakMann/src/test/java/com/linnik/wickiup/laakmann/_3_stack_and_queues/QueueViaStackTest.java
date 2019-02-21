package com.linnik.wickiup.laakmann._3_stack_and_queues;

import org.junit.Assert;
import org.junit.Test;

public class QueueViaStackTest {

	@Test
	public void test() {
		QueueViaStack<Integer> queueViaStack = new QueueViaStack<>();

		queueViaStack.add(1);
		queueViaStack.add(2);
		queueViaStack.add(3);

		Assert.assertEquals(Integer.valueOf(1), queueViaStack.peek());
	}

	@Test
	public void test1() {
		QueueViaStack<Integer> queueViaStack = new QueueViaStack<>();

		queueViaStack.add(1);
		queueViaStack.add(2);
		queueViaStack.add(3);

		Assert.assertEquals(Integer.valueOf(1), queueViaStack.remove());
	}
}
