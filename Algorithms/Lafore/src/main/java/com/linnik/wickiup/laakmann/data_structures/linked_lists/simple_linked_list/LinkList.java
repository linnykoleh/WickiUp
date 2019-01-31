package com.linnik.wickiup.laakmann.data_structures.linked_lists.simple_linked_list;

/**
 * Класс LinkList содержит всего один элемент данных: ссылку на первый элемент списка. Ссылка хранится в поле с именем first. Это единственная информация
 * о местонахождении элементов, которая хранится в списке. Остальные элементы отслеживаются по цепочке ссылок next, начиная с элемента first.
 *
 * @author LinnykOleh
 */
public class LinkList {

	private Link first;

	public LinkList() {
		this.first = null;
	}

	private boolean isEmpty(){
		return first == null;
	}

	public void insertFirst(int iData, double dData){
		final Link newLink = new Link(iData, dData);
		newLink.next = first;
		first = newLink;
	}

	public Link deleteFirst(){
		final Link deletedFirst = first;
		if(!isEmpty()){
			first = first.next;
		}
		return deletedFirst;
	}

	public Link find(int iData){
		Link current = first;
		if(!isEmpty()){
			while (current != null){
				if(current.iData == iData){
					return current;
				}else{
					current = current.next;
				}
			}
			return null;
		}
		return current;
	}

	public Link delete(int iData){
		Link current = first;
		Link previous = first;

		while(current.iData != iData) {
			if(current.next == null)
				return null;
			else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
	}

	public void displayLinkList(){
		Link current = first;
		while (current!= null){
			current.displayDataInfo();
			current = current.next;
		}
		System.out.println("");
	}

}
