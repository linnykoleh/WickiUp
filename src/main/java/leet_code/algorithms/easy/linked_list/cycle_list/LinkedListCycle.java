package leet_code.algorithms.easy.linked_list.cycle_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LinnykOleh
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        final LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.displayList();

        final LinkedListCycle linkedListCycle = new LinkedListCycle();

        boolean result1 = linkedListCycle.hasCycle_1(linkedList.head);
        System.out.println("Has the linked list cycle: " + result1);


        /**
         *
         * |----|   |----|   |----|   |----|   |----|
         * | 5  |   | 4  |   | 3  |   | 2  |   | 1  |
         * |next|-->|next|-->|next|-->|next|-->|next|-->|
         * |----|   |----|   |----|   |----|   |----|   |
         *             |                                |
         *             |<-------------cycle-------------|
         * */

        linkedList.getNodeByVal(1).next = linkedList.getNodeByVal(4);

        boolean result2 = linkedListCycle.hasCycle_1(linkedList.head);
        System.out.println("Has the linked list cycle: " + result2);
    }

    public boolean hasCycle_1(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null){
            if(nodes.contains(head)){
                return true;
            }else{
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle_2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode{

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    void display(){
        System.out.print(" " + val);
    }
}

class LinkedList{

    ListNode head;

    boolean isEmpty(){
        return head == null;
    }

    void insert(int val){
        ListNode listNode = new ListNode(val);
        if(!isEmpty()){
            listNode.next = head;
        }
        head = listNode;
    }

    ListNode getNodeByVal(int val){
        ListNode current = head;
        while (current != null){
            if(current.val == val){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void displayList(){
        System.out.print("\nList:{");
        ListNode current = head;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.print("}\n");
    }

}


