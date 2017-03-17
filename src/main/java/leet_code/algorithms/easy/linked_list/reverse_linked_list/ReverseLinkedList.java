package leet_code.algorithms.easy.linked_list.reverse_linked_list;

/**
 * @author LinnykOleh
 */
public class ReverseLinkedList {


	public static void main(String[] args) {
		ListNode _6 = new ListNode(6);
		ListNode _7 = new ListNode(7);
		ListNode _1 = new ListNode(1);
		ListNode _5 = new ListNode(5);
		ListNode _3 = new ListNode(3);
		ListNode _4 = new ListNode(4);

		_6.next = _7;
		_7.next = _1;
		_1.next = _5;
		_5.next = _3;
		_3.next = _4;
		_4.next = null;

		final ListNode node = reverseList(_6);
		System.out.println(node.val);

	}

	/**
	 * Reverse a singly linked list.
	 *
	 * Example:
	 * 		Given:   1 -> 4 -> 6 -> 3 -> 10
	 * 		Result:	 10 -> 3 -> 6 -> 4 -> 1
	 *
	 * @param head ListNode head
	 * @return     new ListNode head
	 */
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;

		ListNode cur = head;
		ListNode prev = null;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
