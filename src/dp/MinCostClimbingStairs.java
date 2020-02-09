package dp;


public class MinCostClimbingStairs {
	
	public static void main(String[] args) {
		new MinCostClimbingStairs().minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		new MinCostClimbingStairs().minCostClimbingStairs(new int[] {10, 15, 20});

	}
	
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length+1];
		dp[1] = 0; 
		for(int i = 2 ; i <= cost.length ; i++) {
			dp[i] = Math.min(cost[i-1]+dp[i-1], cost[i-2]+dp[i-2]);
		}
		return dp[dp.length-1];
	}
	
	
	int result = Integer.MAX_VALUE;
	public int minCostClimbingStairsI(int[] cost) {
		climbStair(cost, 0, 0);	
		climbStair(cost, 1, 0);	
		return result;
	}
	
	private void climbStair(int[] cost, int index, int sum) {
		if(index >= cost.length) {
			if(result > sum) {
				result = sum;
			}
			return;
		}
		sum = sum + cost[index];
		if(sum > result) {
			return;
		}
		climbStair(cost, index+1, sum);
		climbStair(cost, index+2, sum);		
	}
}
