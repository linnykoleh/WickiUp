package com.linnik.wickiup.lafore.data_structures.hash_tables.chain_method;

/**
 * @author LinnykOleh
 */
public class Link {

    private int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
        this.next = null;
    }

    public int getKey(){
        return iData;
    }

    public void displayInfo(){
        System.out.print(iData + " -> ");
    }
}
