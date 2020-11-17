package dp;

public class JumpGame {
	
	public static void main(String[] args) {
		new JumpGame().canJump(new int[] {2,3,1,1,4});
	}
	
	public boolean canJump(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for(int i = 0 ; i < nums.length ; i++) {
			if(!dp[i]) {
				continue;
			}
			int length = nums[i];
			for(int j = i ; j <= i+length ; j++) {
				dp[j] = true;
				if(j == nums.length-1) {
					return true;
				}
			}
		}
		return false;        
    }

}
