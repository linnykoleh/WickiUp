package leet_code.algorithms.easy.linked_list;

/**
 * @author LinnykOleh
 */
public class RemoveLinkedListElements {


    /**
     * Remove all elements from a linked list of integers that have value val.
     *
     * Example
     *       Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     *       Return: 1 --> 2 --> 3 --> 4 --> 5
     *
     * @param head ListNode head
     * @param val delete value
     * @return    return head
     */
    public ListNode removeElements(ListNode head, int val) {
        final ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode cur = fake;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return fake.next;
    }

    public ListNode removeElements_(ListNode head, int val) {
        final ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode cur = head;
        ListNode prev = fake;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return fake.next;

    }
}
