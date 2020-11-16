package heap;


import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	
	public static void main(String[] args) {
		new SlidingWindowMaximum().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		new MaxSlidingWindow().maxSlidingWindow(new int[] {-7,-8,7,5,7,1,6,0},4);
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length-k+1];
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0 ; i < nums.length ; i++) {
			if(i >= k && !deque.isEmpty() && nums[i-k] == deque.peek()) {
				deque.pollFirst();
			}			
			while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.removeLast();
			}		
			deque.add(nums[i]);		
			if(i >= (k-1)) {
				result[i-k+1] = deque.peek();
			}
		}
		return result;		
	}
	
	public int[] maxSlidingWindowI(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(
				k, Collections.reverseOrder());	
		int[] result = new int[nums.length-k+1]; 
		for(int i = 0 ; i < nums.length ; i++) {
			if(heap.size() != k) {
				heap.add(nums[i]);
				continue;
			} 
			Integer max = heap.peek();
			result[i-k] = max;	
			heap.add(nums[i]);
			int removeVal = nums[i-k];
			heap.remove(removeVal);		
		}
		result[result.length-1] = heap.peek();
		return result;		
	}

}
