package com.linnik.wickiup.laakmann._2_linked_lists;

import org.junit.Assert;
import org.junit.Test;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;
import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

public class LoopDetectionTest {

	/**
	 *  1 -> 2 -> 3 -> 4 -> 5 -> 6
	 *  			   |	     |
	 *  			  11		 7
	 *  			   |		 |
	 *  			  10 <- 9 <- 8
	 */
	@Test
	public void testHasLoop(){
		final Node<Integer> loopNode4 = new Node<>(4);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.appendAsNode(loopNode4);
		linkedList.append(5);
		linkedList.append(6);
		linkedList.append(7);
		linkedList.append(8);
		linkedList.append(9);
		linkedList.append(10);

		final Node<Integer> node11 = new Node<>(11);
		node11.next = loopNode4;
		linkedList.appendAsNode(node11);

		final Node actualLoop = new LoopDetection().findBeginning(linkedList.head);

		Assert.assertEquals(loopNode4, actualLoop);
	}

	/**
	 *  1 -> 2 -> 3 -> 4 -> 5 -> 6
	 *  			   |	     |
	 *  			  13		 7
	 *  			   |		 |
	 *  			  12         8
	 *  			   |         |
	 *  			  11 <-10 <- 9
	 */
	@Test
	public void testHasLoop1(){
		final Node<Integer> loopNode4 = new Node<>(4);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.appendAsNode(loopNode4);
		linkedList.append(5);
		linkedList.append(6);
		linkedList.append(7);
		linkedList.append(8);
		linkedList.append(9);
		linkedList.append(10);
		linkedList.append(11);
		linkedList.append(12);

		final Node<Integer> node13 = new Node<>(13);
		node13.next = loopNode4;
		linkedList.appendAsNode(node13);

		final Node actualLoop = new LoopDetection().findBeginning(linkedList.head);

		Assert.assertEquals(loopNode4, actualLoop);
	}

	/**
	 *  1 -> 2 -> 3 -> 4 -> 5 -> 6
	 */
	@Test
	public void testHasNoLoop(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);

		final Node actualLoop = new LoopDetection().findBeginning(linkedList.head);

		Assert.assertNull(actualLoop);
	}
}
