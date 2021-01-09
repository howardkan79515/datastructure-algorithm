package sort;

import java.util.Random;

public class KthLargestElementInArrayII {
	
	public static void main(String[] args) {
		new KthLargestElementInArrayII().findKthLargest(new int[] {3,6,2,1,7,5}, 4);
	}
	
	Random rand = new Random();
	
	public int findKthLargest(int[] nums, int k) {		
		int result = findElement(nums, k, 0, nums.length-1);
		return result;		
	}
	
	private int findElement(int[] nums, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		int index = getPivot(start, end, nums);
		int kth = nums.length - index;
		if(kth < k) {
			return findElement(nums, k, start, index-1);
		} else if(kth > k) {
			return findElement(nums, k, index+1, end);
		} else {
			return nums[index];
		}
	}
	
	private int getPivot(int start, int end, int[] array) {
		Random rand = new Random();
		int pivotIndex = rand.nextInt((end - start) + 1) + start;
		//Get pivot by random index to prevent time complexity to O(n^2).
		int pivot = array[pivotIndex];
		int index = start;
		for(int i = start; i <= end ; i++) {
			if(pivot <= array[i]) {
				continue;
			} 
			int num = array[i];
			array[i] = array[index];
			array[index] = num;
			if(array[i] == pivot) {
				pivotIndex = i;
			} else if(array[index] == pivot) {
				pivotIndex = index;
			}
			index++;
		}
		array[pivotIndex] = array[index];
		array[index] = pivot;
		return index;		
	}

}
