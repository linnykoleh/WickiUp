package com.linnik.wickiup.laakmann._2_linked_lists;

import org.junit.Assert;
import org.junit.Test;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;
import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

public class DeleteMiddleNodeTest {

	@Test
	public void test() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.appendAsNode(new Node<>(1));
		linkedList.appendAsNode(new Node<>(2));
		linkedList.appendAsNode(new Node<>(3));

		Node<Integer> nodeToRemove = new Node<>(4);
		linkedList.appendAsNode(nodeToRemove);

		linkedList.appendAsNode(new Node<>(5));

		String expected = "1 -> 2 -> 3 -> 5 -> null";
		boolean actual = new DeleteMiddleNode().deleteNode(nodeToRemove);

		Assert.assertTrue(actual);
		Assert.assertEquals(expected, linkedList.head.toString());
	}

}
