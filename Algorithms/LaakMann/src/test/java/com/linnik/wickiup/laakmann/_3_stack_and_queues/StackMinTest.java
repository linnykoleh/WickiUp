package com.linnik.wickiup.laakmann._3_stack_and_queues;

import org.junit.Assert;
import org.junit.Test;

public class StackMinTest {

	@Test
	public void test() {
		StackMin stackMin = new StackMin();

		stackMin.push(5);
		stackMin.push(6);
		stackMin.push(3);
		stackMin.push(7);

		Assert.assertEquals(3, stackMin.min());
	}

	@Test
	public void test1() {
		StackMin stackMin = new StackMin();

		stackMin.push(5);
		stackMin.push(6);
		stackMin.push(3);
		stackMin.push(7);
		stackMin.pop();
		stackMin.pop();

		Assert.assertEquals(5, stackMin.min());
	}
}
