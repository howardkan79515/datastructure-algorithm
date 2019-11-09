package linkedlist;


import java.util.HashSet;

import java.util.Set;

public class LinkedListCycle {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next =  new ListNode(4);
		head.next.next.next.next = head.next;
		new LinkedListCycle().hasCycle(head);
	}
	
	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			if(set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}		
		return false;
	}
	
	public boolean solvedWithTwoPointer(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			if(fast.equals(slow)) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;

	}
	 

}
