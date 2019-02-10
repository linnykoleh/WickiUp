package com.linnik.wickiup.laakmann._2_linked_lists.structures;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test() {
        String expected = "1 -> 2 -> 3 -> 4 -> 5 -> null";

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        final String actual = linkedList.toString();

        Assert.assertEquals(expected, actual);
    }
}
