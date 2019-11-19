package search;



public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
	
		new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0);
	}
	
    public int search(int[] nums, int target) {
    	if(nums.length==0) {
    		return -1;
    	}
    	int count = 0;
    	for(int i = 1 ; i < nums.length ; i++) {
    		if(nums[i-1] > nums[i]) {
    			break;
    		} else {
    			count++;
    		}
    	}
    	int frontAns = binarySearch(nums, target, 0, count);
    	int backAns = binarySearch(nums, target, count+1, nums.length-1);
    	int result = -1;
    	if(frontAns != -1) {
    		result = frontAns;
    	} else if (backAns != -1){
    		result = backAns;
    	}
		return result;
        
    }
    
    public int binarySearch(int[] nums, int target, int start, int end) {	
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

}
