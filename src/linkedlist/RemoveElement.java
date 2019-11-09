package linkedlist;

public class RemoveElement {
	
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		} 
		ListNode now = head;
		head = new ListNode(-1);
		head.next = now;
		ListNode prev = head;
		while(now != null) {
			if(now.val == val) {
				ListNode next = now.next;
				prev.next = next;
			} else {
				prev = now;
			}
			now = now.next;
		}
		return head.next;
	}

}
