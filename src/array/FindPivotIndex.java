package array;


public class FindPivotIndex {
	
	public static void main(String[] args) {
		new FindPivotIndex().pivotIndex(new int[] {-1,-1,0,0,-1,-1});
		new FindPivotIndex().pivotIndex(new int[] {-1,-1,-1,0,1,1});
		new FindPivotIndex().pivotIndex(new int[] {1, 7, 3, 6, 5, 6}); 
		new FindPivotIndex().pivotIndex(new int[] {-1,-1,-1,-1,-1,-1});
		
	}
	
	public int pivotIndex(int[] nums) {
		int rightSum = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			rightSum = rightSum + nums[i];
		}
		int leftSum = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			rightSum = rightSum - nums[i];
			if(i != 0) {
				leftSum = leftSum + nums[i-1];
			}
			if(rightSum == leftSum) {
				return i;
			}
		}
		return -1;
		
	}
	
	

}
