package sort;

public class KthLargestElementInArray {
	
	public static void main(String[] args) {
		new KthLargestElementInArray().findKthLargest(new int[] {3,6,2,1,7,5}, 5);
	}

	
	public int findKthLargest(int[] nums, int k) {		
		int result = searchByPartition(nums, k, 0, nums.length-1);
		return result;		
	}
	
	private int searchByPartition(int[] nums, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		int index = partition(nums, start, end);
		int target = nums.length - index;
		if(k < target) {
			return searchByPartition(nums, k, index+1, end);
		} else if (k > target) {
			return searchByPartition(nums, k, start, index-1);
		} else {
			return nums[index];
		}	
	}
	
	private int partition(int[] nums, int start, int end) {
		int index = start;
		int pivot = nums[end];
		for(int i = start ; i < end ; i++) {
			if(nums[i] < pivot) {
				int val = nums[index];
				nums[index] = nums[i];
				nums[i] = val;
				index++;
			}
		}
		int val = nums[index];
		nums[index] = pivot;
		nums[end] = val;		
		return index;
	}

}
