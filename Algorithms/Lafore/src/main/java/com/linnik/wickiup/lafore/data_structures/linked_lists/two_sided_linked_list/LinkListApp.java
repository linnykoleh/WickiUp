package com.linnik.wickiup.lafore.data_structures.linked_lists.two_sided_linked_list;


/**
 * @author LinnykOleh
 */
public class LinkListApp {

	public static void main(String[] args) {

		final LinkList linkList = new LinkList();

		linkList.insertFirst(1);
		linkList.insertFirst(2);
		linkList.insertFirst(3);
		linkList.insertFirst(4);
		linkList.insertFirst(5);
		linkList.insertFirst(6);

		linkList.displayList();

		linkList.insertLast(7);

		linkList.displayList();

		linkList.deleteFirst();
		linkList.deleteFirst();

		linkList.displayList();
	}
}
