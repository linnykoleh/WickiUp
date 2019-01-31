package com.linnik.wickiup.leet_code.algorithms.medium.linked_list.reorder_list;

/**
 * @author LinnykOleh
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        ListNode _6 = new ListNode(6);

        _1.next = _2;_2.next = _3;_3.next = _4;_4.next = _5;_5.next = _6;_6.next = null;

        System.out.println(_1);

        reorderList(_1);

        System.out.println(_1);
    }


    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * You must do this in-place without altering the nodes' values.
     *
     * For example,
     *      Given {1,2,3,4}, reorder it to {1,4,2,3}.
     *
     * @param head of linked list
     */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode cur = head;
        while(cur.next != null){
            ListNode then = cur.next;
            if(then.next == null) break;
            ListNode n = findN(head);
            cur.next = n;
            n.next = then;
            cur = then;
        }
    }

    public static ListNode findN(ListNode head){
        ListNode cur = head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        ListNode n = cur.next;
        cur.next = n.next;
        return n;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}