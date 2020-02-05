package dp;




import java.util.Stack;

public class TargetSum {
	
	public static void main(String[] args) {
		new TargetSum().findTargetSumWays(new int[] {0,0,0,0,0,0,0,0,1}, 1);
		new TargetSum().findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3);
	}
	
	int result = 0;
	
	//dynamic programming
	public int findTargetSumWays(int[] nums, int S) {
		int[][] dp = new int[nums.length][2001];
		dp[0][1000+nums[0]] = 1;
		dp[0][1000-nums[0]] = dp[0][1000-nums[0]] == 1 ? 2 : 1;
		for(int i = 1 ; i < nums.length ; i++) {
			for(int j = 0 ; j < 2000 ; j++) {
				if(dp[i-1][j] == 0) {
					continue;
				}
				dp[i][j+nums[i]] = dp[i][j+nums[i]]+1*dp[i-1][j];
				dp[i][j-nums[i]] = dp[i][j-nums[i]]+1*dp[i-1][j];
				System.out.print("j:"+j+"\n");
				System.out.print(j+nums[i]+"\n");
				System.out.print(j-nums[i]+"\n");
			}
			System.out.print("------------------------"+"\n");
		}		

		int result = S > 1000 ? 0 : dp[nums.length-1][1000+S];		
		return result;        
    }

	
	public class Node {
		int index;		
		int value;
		
		public Node(int value, int index) {
			this.index = index;
			this.value = value;
		}
	}
	
	//Solved by Stack
    public int findTargetSumWaysI(int[] nums, int S) {
		Stack<Node> stack = new Stack<>();
		Node root = new Node(0, -1);
		stack.add(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if(node.index == nums.length-1) {
				if(node.value == S) {
					result++;
				}
				continue;
			}
			Node leftVal = new Node(node.value + nums[node.index+1], node.index+1); 
			Node rightVal = new Node(node.value - nums[node.index+1], node.index+1); 
			stack.add(rightVal);
			stack.add(leftVal);			
		}
		return result;
	}
	
	
	//Brute Force
	public int findTargetSumWaysII(int[] nums, int S) {
		calSum(nums, S, 0, 0);
		return result;
        
    }
	
	private void calSum(int[] nums, int S, int index, int sum) {
		if(index == nums.length) {
			if(sum == S) {
				result++;
			}
			return;
		}
		calSum(nums, S, index+1, sum+nums[index]);
		calSum(nums, S, index+1, sum-nums[index]);
	}
	


}
