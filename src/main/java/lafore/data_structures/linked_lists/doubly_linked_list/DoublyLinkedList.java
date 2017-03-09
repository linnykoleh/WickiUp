package lafore.data_structures.linked_lists.doubly_linked_list;

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
			last = newLink;
		} else {
			last.next= newLink;
		}
		newLink.previous = last;
		last = newLink;
	}

	public void insertAfter(int iData){

	}
}
