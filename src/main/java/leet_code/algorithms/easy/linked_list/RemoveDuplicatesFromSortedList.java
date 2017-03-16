package leet_code.algorithms.easy.linked_list;

/**
 * @author LinnykOleh
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
	 * For example,
	 * 		Given 1->1->2, return 1->2.
	 * 		Given 1->1->2->3->3, return 1->2->3.
	 *
	 * @param head of linked List
	 * @return    head list node
	 */
	public ListNode deleteDuplicates(ListNode head) {

		ListNode current = head;
		while(current != null && current.next != null){
			while(current.val == current.next.val){
				current.val = current.next.val;
				current.next = current.next.next;
				if(current.next == null){
					break;
				}
			}
			current = current.next;
		}
		return head;
	}

	public ListNode _deleteDuplicates(ListNode head) {

		if(head == null || head.next == null)
			return head;

		ListNode current = head;
		while(current != null && current.next != null){
			if(current.val == current.next.val){
				current.next = current.next.next;
			}else{
				current = current.next;
			}
		}
		return head;
	}

}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
