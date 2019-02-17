package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;
import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;
import org.junit.Assert;
import org.junit.Test;

public class SumListsTest {

    @Test
    public void test1() {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.append(7);
        linkedList1.append(1);
        linkedList1.append(6);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.append(5);
        linkedList2.append(9);
        linkedList2.append(2);

        String expected = "1 -> 3 -> 0 -> 8 -> null";

        SumLists sumLists = new SumLists();
        Node actual = sumLists.addLists(linkedList1.head, linkedList2.head);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test2() {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.append(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(4);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.append(5);
        linkedList2.append(6);
        linkedList2.append(7);

        String expected = "1 -> 8 -> 0 -> 1 -> null";

        SumLists sumLists = new SumLists();
        Node actual = sumLists.addLists(linkedList1.head, linkedList2.head);

        Assert.assertEquals(expected, actual.toString());
    }
}
