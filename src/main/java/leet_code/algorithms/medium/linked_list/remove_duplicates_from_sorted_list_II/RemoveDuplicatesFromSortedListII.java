package leet_code.algorithms.medium.linked_list.remove_duplicates_from_sorted_list_II;

/**
 * @author LinnykOleh
 */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode _1 = new ListNode(1);
		ListNode _2 = new ListNode(1);
		ListNode _3 = new ListNode(1);
		ListNode _4 = new ListNode(4);
		ListNode _5 = new ListNode(5);
		ListNode _6 = new ListNode(6);

		_1.next = _2;_2.next = _3;_3.next = _4;_4.next = _5;_5.next = _6;_6.next = null;

		System.out.println(_1);

		deleteDuplicates(_1);

		System.out.println(_1);

	}

	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 *
	 * For example,
	 *          Given 1->2->3->3->4->4->5, return 1->2->5.
	 *          Given 1->1->1->2->3, return 2->3.
	 *
	 * @param head of LinkedList
	 * @return    head of LinkedList where removed duplicates
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;

		ListNode fake=new ListNode(-1);
		fake.next=head;

		ListNode pre=fake;
		ListNode cur=head;
		while(cur != null){
			while(cur.next != null && cur.val == cur.next.val){
				cur=cur.next;
			}
			if(pre.next==cur){
				pre=pre.next;
			}else{
				pre.next=cur.next;
			}
			cur=cur.next;
		}
		return fake.next;
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
