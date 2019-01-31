package com.linnik.wickiup.laakmann.data_structures.linked_lists.simple_linked_list;

/**
 * @author LinnykOleh
 */
public class LinkListApp {

	public static void main(String[] args) {

		final LinkList linkList = new LinkList();

		linkList.insertFirst(1,1);
		linkList.insertFirst(2,2);
		linkList.insertFirst(3,3);
		linkList.insertFirst(4,4);
		linkList.insertFirst(5,5);
		linkList.insertFirst(6,6);

		linkList.displayLinkList();

		linkList.deleteFirst();
		linkList.deleteFirst();

		linkList.displayLinkList();

		final Link link = linkList.find(2);
		link.displayDataInfo();

		linkList.delete(2);

		linkList.displayLinkList();
	}
}
