package search;

public class BinarySearch {
	
	public static void main(String[] args) {
		new BinarySearch().searchByRecursion(new int[] {1,2,3,5,8,7}, 4);
		new BinarySearch().search(new int[] {1,2,3,5,8,7}, 8);
	}
	
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;		
		while(start <= end) {
			int mid = (start + end)/2; 
			if(nums[mid] < target) {
				start = mid+1;
			} else if(nums[mid] > target) {
				end = mid-1;
			} else {
				return mid;
			}
		}		
		return -1;		
	}
	
	public int searchByRecursion(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		return doRecursion(nums, start, end, target);
		
	}
	
	private int doRecursion(int[] nums, int start, int end, int target) {
		if(start > end) {
			return -1;
		}
		int mid = (start+end)/2; 
		if(nums[mid] < target) {
			return doRecursion(nums, mid+1, end, target);
		} else if(nums[mid] > target) {
			return doRecursion(nums, start, mid-1, target);
		} else {
			return mid;
		}		
	}

}
