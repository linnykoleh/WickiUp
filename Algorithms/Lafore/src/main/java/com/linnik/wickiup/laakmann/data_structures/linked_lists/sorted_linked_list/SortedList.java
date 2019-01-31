package com.linnik.wickiup.laakmann.data_structures.linked_lists.sorted_linked_list;

/**
 * @author LinnykOleh
 */
public class SortedList {

    private Link first;

    private boolean isEmpty(){
        return first == null;
    }

    public void insert(int iData){
        final Link newLink = new Link(iData);
        Link current = first;
        Link previous = null;

        while(current != null && current.iData < iData){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            first = newLink;
        }else{
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link remove(){
        Link tmp = first;
        first = first.next;
        return tmp;
    }

    public void displayList(){
        System.out.println("");
        System.out.print("Linked list{ ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.print(" }");
        System.out.println("");
    }
}
