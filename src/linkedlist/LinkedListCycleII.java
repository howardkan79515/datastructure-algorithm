package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next =  new ListNode(-4);
		head.next.next.next.next = head.next;
		new LinkedListCycleII().detectCycle(head);
	}
	
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			if(set.contains(head)) {
				return head;
			}
			set.add(head);
			head = head.next;
		}
		
		return null;
	}
}
