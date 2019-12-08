package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	
	public static void main(String[] args) {
		new SlidingWindowMaximum().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0) {
			return nums;
		}
		int[] result = new int[nums.length-(k-1)];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				Collections.reverseOrder());
		for(int i = 0 ; i < k ; i++) {
			queue.add(nums[i]);
		} 
		for(int i = k ; i < nums.length ; i++) {
			int formerMax = queue.peek();
			result[i-k] = formerMax;
			queue.remove(nums[i-k]);
			queue.add(nums[i]);
		}
		result[nums.length-k] = queue.peek();
		return nums;       
    }

}
