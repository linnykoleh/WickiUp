package com.linnik.wickiup.leet_code.algorithms.easy.linked_list.delete_node;

/**
 * @author LinnykOleh
 */
public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        final LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.displayList();

        ListNode node = linkedList.getNodeByValue(3);

        new DeleteNodeInLinkedList().deleteNode(node);

        linkedList.displayList();

    }

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     *
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     * the linked list should become 1 -> 2 -> 4 after calling your function.
     *
     * @param node to delete node
     */
    public void deleteNode(ListNode node) {
        if(node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
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

    ListNode first;

    boolean isEmpty(){
        return first == null;
    }

    void insert(int val){
        ListNode newNode = new ListNode(val);
        if(!isEmpty()){
            newNode.next = first;
        }
        first = newNode;
    }

    void displayList(){
        System.out.print("\nList: {");
        ListNode current = first;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.print("}\n");
    }

    ListNode getNodeByValue(int val){
        ListNode current = first;
        while (current != null){
            if(current.val == val){
                return current;
            }
            current = current.next;
        }
        return null;
    }

}


