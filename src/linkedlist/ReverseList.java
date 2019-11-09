package linkedlist;

public class ReverseList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		new ReverseList().reverseList(head);
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode slow = head;
		while(slow!=null) {
			ListNode next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}		
		return prev;

	}
}
