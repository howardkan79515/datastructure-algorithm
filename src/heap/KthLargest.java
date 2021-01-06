package heap;

import java.util.PriorityQueue;

public class KthLargest {
	
	public static void main(String[] args) {
		KthLargest k = new KthLargest(2, new int[] {0});
		k.add(-1);
		k.add(1);
		k.add(-2);
	}
	
	PriorityQueue<Integer> heap = new PriorityQueue<>(); 
	
	int k;

    public KthLargest(int k, int[] nums) {
    	if(nums.length == 0) {
    		return;
    	}
    	this.k = k;
    	for(int i = 0 ; i < nums.length ; i++) {
    		if(i < k) {
    			heap.add(nums[i]);
    			continue;
    		}
    		if(nums[i] > heap.peek()) {
    			heap.poll();
    			heap.add(nums[i]);
    		}    		
    	}        
    }
    
    public int add(int val) {
    	if(heap.size() == 0) {
    		heap.add(val);
    		return val;
    	}
    	if(heap.size() < k) {
    		heap.add(val);
    	} else if(val > heap.peek()) {
    		heap.poll();
			heap.add(val);
    	}
		return heap.peek();       
    }

}
