package dp;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = 1;
        }
        for (int j = 1; j < dp.length ; j++) {
            for (int i = 1; i < dp[j].length; i++) {
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }
        return dp[m-1][n-1];
    }

}
