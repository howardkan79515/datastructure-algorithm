package dp;

public class HouseRobber {
	public static void main(String[] args) {
		new HouseRobber().rob(new int[] {2, 1, 1, 2});
	}
	public int rob(int[] nums) {
		int[] state = new int[nums.length];
		int max = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			if(i == 2) {
				max = nums[0];
			} else if(i > 2) {
				max = Math.max(state[i-2], state[i-3]);
			}
			state[i] = nums[i] + max;
		}
		int result = 0;
		for(int i = 0 ; i < state.length ; i++) {
			if(result < state[i]) {
				result = state[i];
			}
		}
		return result;       
	}
	
	

	
}
