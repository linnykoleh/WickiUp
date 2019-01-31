package com.linnik.wickiup.lafore.data_structures.hash_tables.chain_method;

/**
 * @author LinnykOleh
 */
public class SortedList {

    private Link first;

    public SortedList() {
        this.first = null;
    }

    public void insert(Link theLink){
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }

        if(previous == null){
            first = theLink;
        }else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete(int key){
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()){
            previous = current;
            current = current.next;
        }

        if(previous == null){
            first = first.next;
        }else {
            previous.next = current.next;
        }
    }

    public Link find(int key){
        Link current = first;

        while (current != null && current.getKey() <= key){
            if(current.getKey() == key){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList(){
        Link current = first;
        while (current != null){
            current.displayInfo();
            current = current.next;
        }
        System.out.println("");
    }
}
