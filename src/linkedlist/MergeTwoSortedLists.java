package linkedlist;

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(7);
		new MergeTwoSortedLists().mergeTwoLists(l1, l2);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(-1);
		ListNode result = node;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else if(l2.val < l1.val) {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			} else {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
				node.next = l2;
				node = node.next;
				l2 = l2.next;				
			}			
		}
		
		if(l1 != null) {
			node.next = l1;
		} else if(l2 != null) {
			node.next = l2;
		}
		
		return result.next;
        
    }

}
