package com.linnik.wickiup.laakmann._3_stack_and_queues;

import org.junit.Assert;
import org.junit.Test;

public class StackOfPlatesTest {

	@Test
	public void test() {
		StackOfPlates stackOfPlates = new StackOfPlates(3);

		stackOfPlates.push(1);
		stackOfPlates.push(2);
		stackOfPlates.push(3);

		stackOfPlates.push(3);
		stackOfPlates.push(4);
		stackOfPlates.push(5);

		stackOfPlates.push(6);
		stackOfPlates.push(7);
		stackOfPlates.push(8);

		final int pop8 = stackOfPlates.pop();
		final int pop7 = stackOfPlates.pop();
		final int pop6 = stackOfPlates.pop();

		final int pop5 = stackOfPlates.pop();

		Assert.assertEquals(8, pop8);
		Assert.assertEquals(7, pop7);
		Assert.assertEquals(6, pop6);
		Assert.assertEquals(5, pop5);
	}
}
