package dp;

public class KnightProbabilityInChessboard {
	int ans = 0;
	int count = 0;
	
	public static void main(String[] args) {
		new KnightProbabilityInChessboard().knightProbability(1, 0, 0, 0);
		new KnightProbabilityInChessboard().knightProbability(3, 2, 0, 0);
	}
	
	public double knightProbability(int N, int K, int r, int c) {		
		double[][] status = new double[N][N];
		int[] nums = new int[] {1,2,-1,-2,1,-2,-1,2,2,1,-2,-1,2,-1,-2,1};
		status[r][c] = 1;
		for(int n = 0 ; n < K ; n++) {
			double[][] status2 = new double[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(status[i][j] == 0) {
						continue;
					}
					for(int m = 0 ; m < nums.length ; m+=2) {
						int x = i + nums[m];
						int y = j + nums[m+1];
					    if(x < 0 || x >= N || y < 0 || y >= N) {
					    	continue;
					    }
						status2[x][y] = status2[x][y] + status[i][j] * 1/8.0;
					}
				}
			}
			status = status2;
		}
		
		double result = 0;
		for(int i = 0 ; i < status.length ; i++) {
			for(int j = 0 ; j < status.length ; j++) {
				result = result + status[i][j];
			}
		}
		return result;
	}
	

	


}
