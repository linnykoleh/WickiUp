package com.linnik.wickiup.lafore.data_structures.linked_lists.simple_linked_list;

/**
 * @author LinnykOleh
 */
public class Link {

	public int iData;
	public double dData;
	public Link next;

	public Link(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
		this.next = null;
	}

	public void displayDataInfo(){
		System.out.println("{iData: " + iData + " dData: " + dData + "}");
	}
}
