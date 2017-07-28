package com.linnik.wickiup.lafore.data_structures.linked_lists.doubly_linked_list;

/**
 * @author LinnykOleh
 */
public class DoublyLinkedList {

	private Link first;
	private Link last;

	private boolean isEmpty(){
		return first == null;
	}

	public void insertFirst(int iData){
		final Link newLink = new Link(iData);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int iData){
		final Link newLink = new Link(iData);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public boolean insertAfter(int key, int iData){
		Link current = first;
		while (current.iData != key) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		Link newLink = new Link(iData);
		if(current == last){
			newLink.next = null;
		}else{
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}

	public Link deleteFirst(){
		Link tmp = first;
		if(first.next == null){
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return tmp;
	}

	public Link deleteLast(){
		Link tmp = last;
		if(first.next == null){
			first = null;
		}else{
			last.previous.next = null;
		}
		last = last.previous;
		return tmp;
	}

	public Link deleteKey(int iData){
		Link current = first;
		while (current.iData != iData){
			current = current.next;
			if(current == null){
				return null;
			}
		}
		if(current == first){
			first = current.next;
		}else {
			current.previous.next = current.next;
		}

		if(current == last){
			last = current.previous;
		}else {
			current.next.previous = current.previous;
		}
		return current;
	}

	public void displayForward(){
		System.out.println("List (first --> Last) :");
		Link current = first;
		while (current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}

	public void displayBackward(){
		System.out.println("List (last --> first) : ");
		Link current = last;
		while (current != null){
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
}
