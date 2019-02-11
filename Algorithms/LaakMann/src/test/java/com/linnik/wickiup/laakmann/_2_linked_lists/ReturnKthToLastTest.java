package com.linnik.wickiup.laakmann._2_linked_lists;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;
import com.linnik.wickiup.laakmann._2_linked_lists.structures.Node;
import org.junit.Assert;
import org.junit.Test;

public class ReturnKthToLastTest {

    @Test
    public void test1() {
        LinkedList<Integer> linkedList = getLinkedList();

        new ReturnKthToLast().printKthToLast(linkedList.head, 3);
        // 3th to last node is 6
        // 3th to last node is 5
        // 3th to last node is 4
    }

    @Test
    public void test2() {
        String expected = "4 -> 5 -> 6 -> null";
        LinkedList<Integer> linkedList = getLinkedList();

        Node node = new ReturnKthToLast().nthTolast(linkedList.head, 3);

        Assert.assertEquals(expected, node.toString());
    }

    private LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        return linkedList;
    }
}
