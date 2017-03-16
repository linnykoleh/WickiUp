package leet_code.algorithms.easy.linked_list.intersection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LinnykOleh
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        example_1();
        example_2();
        example_3();
        example_4();

    }

    private static void example_4(){
        System.out.println("\n************* Example 4 *****************");

        final ListNode interNode = new ListNode(4);

        final LinkedList linkedListA = new LinkedList();
        final ListNode listNodeA3 = new ListNode(3);
        listNodeA3.next = interNode;
        linkedListA.insert(listNodeA3);
        linkedListA.insert(new ListNode(2));
        linkedListA.insert(new ListNode(1));
        linkedListA.display();

        final LinkedList linkedListB = new LinkedList();
        final ListNode listNodeB3 = new ListNode(3);
        listNodeB3.next = interNode;
        linkedListB.insert(listNodeB3);
        linkedListB.insert(new ListNode(2));
        linkedListB.insert(new ListNode(1));
        linkedListB.insert(new ListNode(0));
        linkedListB.display();

        final ListNode intersectionNode = getIntersectionNode_2(linkedListA.head, linkedListB.head);
        System.out.println("\nIntersection: "+intersectionNode.val);
    }

    private static void example_3(){
        System.out.println("\n************* Example 3 *****************");

        final ListNode interNode = new ListNode(1);

        final LinkedList linkedListA = new LinkedList();
        linkedListA.insert(interNode);
        linkedListA.display();

        final LinkedList linkedListB = new LinkedList();
        linkedListB.insert(interNode);
        linkedListB.display();

        final ListNode intersectionNode = getIntersectionNode_1(linkedListA.head, linkedListB.head);
        System.out.println("\nIntersection: "+intersectionNode.val);
    }

    private static void example_2(){
        System.out.println("\n************* Example 2 *****************");

        final ListNode interNode = new ListNode(1);

        final LinkedList linkedListA = new LinkedList();
        final ListNode nodeA1 = new ListNode(1);
        nodeA1.next = interNode;
        linkedListA.insert(nodeA1);
        linkedListA.display();

        final LinkedList linkedListB = new LinkedList();
        final ListNode nodeB1 = new ListNode(1);
        nodeB1.next = interNode;
        linkedListB.insert(nodeB1);

        linkedListB.display();

        final ListNode intersectionNode = getIntersectionNode_1(linkedListA.head, linkedListB.head);
        System.out.println("\nIntersection: "+intersectionNode.val);
    }

    private static void example_1(){
        System.out.println("\n************* Example 1 *****************");

        final ListNode interNode = new ListNode(4);

        final LinkedList linkedListA = new LinkedList();
        final ListNode nodeA3 = new ListNode(3);
        nodeA3.next = interNode;
        linkedListA.insert(nodeA3);
        linkedListA.insert(new ListNode(2));
        linkedListA.insert(new ListNode(1));
        linkedListA.display();

        final LinkedList linkedListB = new LinkedList();
        final ListNode nodeB3 = new ListNode(3);
        nodeB3.next = interNode;
        linkedListB.insert(nodeB3);
        linkedListB.insert(new ListNode(2));
        linkedListB.insert(new ListNode(1));
        linkedListB.display();

        final ListNode intersectionNode = getIntersectionNode_1(linkedListA.head, linkedListB.head);
        System.out.println("\nIntersection: "+intersectionNode.val);
    }

    /**
     * Approach using has code.
     * Runtime = 17 ms
     *
     * @param headA ListNode A
     * @param headB ListNode B
     * @return      intersection node
     */
    private static ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        final Set<ListNode> nodesA = new HashSet<>();

        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null){
            nodesA.add(currentA);
            currentA = currentA.next;
        }

        while (currentB != null){
            if(nodesA.contains(currentB)){
                return currentB;
            }
            currentB = currentB.next;
        }
        return null;
    }

    /**
     * O(n) time, O(1) space.
     * ! Runtime = 2 ms
     *
     * @param headA ListNode A
     * @param headB ListNode B
     * @return      intersection node
     */
    private static ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if(null == headA || null == headB )
            return null;

        ListNode curA = headA;
        ListNode curB = headB;
        while( curA != curB){
            if(curA == null){
                curA = headB;
            }else{
                curA = curA.next;
            }

            if(curB == null){
                curB = headA;
            }else{
                curB = curB.next;
            }
        }
        return curA;
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

    void insert(ListNode listNode){
        if(!isEmpty()){
            listNode.next = head;
        }
        head = listNode;
    }

    void display(){
        System.out.print("\nList:{");
        ListNode current = head;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.print(" }");
    }

}
