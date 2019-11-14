package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		//int[] input = new int[] {3,6,2,1,7,5};
		int[] input = new int[] {5,1,1,2,0,0};
		new MergeSort().sort(input);
	}
	
	public int[] sort(final int[] nums) {
		if(nums.length <= 1) {
			return nums;
		}
		int mid = nums.length/2;
		int[] left = Arrays.copyOfRange(nums, 0, mid);
		int[] right = Arrays.copyOfRange(nums, mid, nums.length);
		sort(left);
		sort(right);		
		return merge(left, right, nums);	
	}
	
	private int[] merge(final int[] left, final int[] right, final int[] nums) {
		int leftIndex = 0;
		int rightIndex = 0;
		int i = 0;
		while(leftIndex < left.length && rightIndex < right.length) {			
			if(left[leftIndex] < right[rightIndex]) {
				nums[i] = left[leftIndex];
				leftIndex++;
			} else if(left[leftIndex] > right[rightIndex]) {
				nums[i] = right[rightIndex];
				rightIndex++;
			} else {
				nums[i] = left[leftIndex];
				leftIndex++;
			}
			i++;
		}
		int[] restNums = leftIndex == left.length ? right : left;
		int index = leftIndex == left.length ? rightIndex : leftIndex;
		for(int j = i ; j < nums.length ; j++) {
			nums[j] = restNums[index];
			index++;
		}
		return nums;
	}

}
