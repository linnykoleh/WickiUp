package com.linnik.wickiup.laakmann._2_linked_lists;

import org.junit.Assert;
import org.junit.Test;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;
import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;

public class IntersectionTest {

	@Test
	public void testIntersected() {
		Node<Integer> intersectionNode = new Node<>(7);

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.append(3);
		linkedList1.append(1);
		linkedList1.append(5);
		linkedList1.append(9);
		linkedList1.appendAsNode(intersectionNode);
		linkedList1.append(2);
		linkedList1.append(1);

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.append(4);
		linkedList2.append(6);
		linkedList2.appendAsNode(intersectionNode);
		linkedList2.append(2);
		linkedList2.append(1);

		final Node actual = new Intersection().findIntersection(linkedList1.head, linkedList2.head);

		Assert.assertEquals(7, actual.value);
	}

	@Test
	public void testNotIntersected() {
		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.append(3);
		linkedList1.append(1);
		linkedList1.append(5);
		linkedList1.append(9);
		linkedList1.append(7);
		linkedList1.append(2);
		linkedList1.append(1);

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.append(4);
		linkedList2.append(6);
		linkedList2.append(7);
		linkedList2.append(2);
		linkedList2.append(1);

		final Node actual = new Intersection().findIntersection(linkedList1.head, linkedList2.head);

		Assert.assertNull(actual);
	}
}
