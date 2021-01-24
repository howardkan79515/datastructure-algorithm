package linkedlist;

public class SwapNodesInPairs {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		new SwapNodesInPairs().swapPairs(head);
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode prev = new ListNode(-1);
		prev.next = head;
		ListNode result = prev;
		while(head != null) {
			ListNode next = head.next;
			if(next == null) {
				break; 
			}
			head.next = next.next;
			next.next = head;
			prev.next = next;
			prev = head;
			head = head.next;
		}		
		return result.next;
        
    }

}
