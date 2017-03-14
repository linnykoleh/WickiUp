package leet_code.algorithms.easy.linked_list.intersection;

/**
 * @author LinnykOleh
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        example_1();
        example_2();
        example_3();

    }

    private static void example_3(){
        System.out.println("\n Example 3*****************************");

        final ListNode interNode = new ListNode(1);

        final LinkedList linkedListA = new LinkedList();
        linkedListA.insert(interNode);
        linkedListA.display();

        final LinkedList linkedListB = new LinkedList();
        linkedListB.insert(interNode);
        linkedListB.display();

        final ListNode intersectionNode = getIntersectionNode(linkedListA.head, linkedListB.head);
        System.out.println(intersectionNode.val);
    }
    private static void example_2(){
        System.out.println("\n Example 2*****************************");

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

        final ListNode intersectionNode = getIntersectionNode(linkedListA.head, linkedListB.head);
        System.out.println(intersectionNode.val);
    }

    private static void example_1(){
        System.out.println("\n Example 1*****************************");

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

        final ListNode intersectionNode = getIntersectionNode(linkedListA.head, linkedListB.head);
        System.out.println(intersectionNode.val);
    }


    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        while(currentA != null && currentB != null){
            if(currentA == currentB){
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
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
        System.out.println(" }");
    }

}
