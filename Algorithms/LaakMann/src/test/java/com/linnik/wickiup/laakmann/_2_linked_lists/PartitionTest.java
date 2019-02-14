package com.linnik.wickiup.laakmann._2_linked_lists;

import org.junit.Assert;
import org.junit.Test;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;

public class PartitionTest {

	@Test
	public void test() {
		String expect = "1 -> 2 -> 3 -> 8 -> 5 -> 10 -> null";
		String actual = "3 -> 8 -> 5 -> 10 -> 2 -> 1 -> null";
		Partition partition = new Partition();

		actual = partition.partition(getLinkedList().head, 5).toString();

		Assert.assertEquals(expect, actual);
	}

	private LinkedList<Integer> getLinkedList() {
		LinkedList<Integer> linkedList = new LinkedList<>();

		linkedList.append(3);
		linkedList.append(8);
		linkedList.append(5);
		linkedList.append(10);
		linkedList.append(2);
		linkedList.append(1);

		return linkedList;
	}
}
