package com.linnik.wickiup.laakmann._3_stack_and_queues;

import org.junit.Assert;
import org.junit.Test;

public class ThreeInOneTest {

	@Test
	public void test1() {
		ThreeInOne threeInOne = new ThreeInOne(5);

		threeInOne.push(1, 1);

		final int peek = threeInOne.peek(1);

		Assert.assertEquals(1, peek);
	}

	@Test
	public void tes2() {
		ThreeInOne threeInOne = new ThreeInOne(10);

		threeInOne.push(0, 1);
		threeInOne.push(0, 2);
		threeInOne.push(0, 3);

		threeInOne.push(1, 1);
		threeInOne.push(1, 2);
		threeInOne.push(1, 3);

		threeInOne.push(2, 1);
		threeInOne.push(2, 2);
		threeInOne.push(2, 3);

		final int peek1 = threeInOne.pop(0);
		final int peek2 = threeInOne.pop(1);
		final int peek3 = threeInOne.pop(2);

		Assert.assertEquals(3, peek1);
		Assert.assertEquals(3, peek2);
		Assert.assertEquals(3, peek3);
	}
}
