package search;

public class FindFirstAndLastInSortedArray {
	
	public static void main(String[] args) {
		new FindFirstAndLastInSortedArray()
		.searchRange(new int[] {1}, 1);
		new FindFirstAndLastInSortedArray()
		.searchRange(new int[] {5,7,7,8,8,8,10}, 8);
	}
	
	public int[] searchRange(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		int[] result = new int[] {-1,-1};
		while(start <= end) {
			int mid = (start+end)/2;
			if(target < nums[mid]) {
				end = mid - 1;
			} else if(target > nums[mid]) {
				start = mid + 1;
			} else {
				int first = 0;
				int last = 0;
			    for(int i = mid ; i >= 0 ; i--) {
			    	if(nums[i] != target) {
			    		break;
			    	} else {
			    		first = i;
			    	}
			    }
			    for(int i = first ; i < nums.length ; i++) {
			    	if(nums[i] != target) {
			    		break;
			    	} else {
			    		last = i;	
			    	}
			    }
				return new int[] {first, last};
			}
		}		
		return result;
        
    }
	

}
