package array;


public class LargestNumberAtLeastTwiceOfOthers {
	
	public static void main(String[] args) {
		new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[] {1,0});
		new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[] {1, 2, 3, 4});
		new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[] {3, 2, 6, 0});
	}
	
	
	public int dominantIndex(int[] nums) {
		int unPass = 0;
		int max = nums[0];
		int result = 0;
		for(int i = 1 ; i < nums.length ; i++) {
			if(nums[i] > max) {
				if(nums[i] < max * 2) {
					unPass = calUnPass(nums, unPass, i);
				}
				max = nums[i];
				result = i;
				continue;
			}
			if(max < nums[i] * 2) {
				unPass = calUnPass(nums, unPass, i);
			}
		} 	
		if(unPass * 2 > max) {
			result = -1;
		} 
		return result;
        
    }


	private int calUnPass(int[] nums, int unPass, int i) {
		unPass = nums[i] > unPass ? nums[i] : unPass;
		return unPass;
	}

}
