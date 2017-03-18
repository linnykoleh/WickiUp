package leet_code.algorithms.medium.linked_list.reverse_linked_list;

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

		final ListNode node = reverseBetween(_6, 2, 5);
		System.out.println(node.val);

	}


	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 *
	 * For example:
	 * 		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 		return 1->4->3->2->5->NULL.
     *
	 * Note:
	 * 		Given m, n satisfy the following condition:
	 * 		1 ≤ m ≤ n ≤ length of list.
	 *
	 *
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for(int i = 0; i<m-1; i++){
			pre = pre.next;
		}

		ListNode start = pre.next;
		ListNode then = start.next;

		for(int i=0; i<n-m; i++){
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		return dummy.next;
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
