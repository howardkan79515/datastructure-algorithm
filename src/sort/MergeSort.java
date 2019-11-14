package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] input = new int[] {3,6,2,1,7,5};
		new MergeSort().sort(input);
	}
	
	public int[] sort(final int[] nums) {
		if(nums.length <= 1) {
			return nums;
		}
		int mid = nums.length/2;
		int[] left = Arrays.copyOfRange(nums, 0, mid);
		int[] right = Arrays.copyOfRange(nums, mid, nums.length);
		left = sort(left);
		right = sort(right);		
		return merge(left, right);	
	}
	
	private int[] merge(final int[] left, final int[] right) {
		int[] result = new int[left.length+right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int i = 0;
		while(leftIndex < left.length && rightIndex < right.length) {			
			if(left[leftIndex] < right[rightIndex]) {
				result[i] = left[leftIndex];
				leftIndex++;
			} else if(left[leftIndex] > right[rightIndex]) {
				result[i] = right[rightIndex];
				rightIndex++;
			} else {
				result[i] = result[leftIndex];
				leftIndex++;
			}
			i++;
		}
		int[] restNums = leftIndex == left.length ? right : left;
		int index = leftIndex == left.length ? rightIndex : leftIndex;
		for(int j = i ; j < result.length ; j++) {
			result[j] = restNums[index];
			index++;
		}
		return result;
	}

}
