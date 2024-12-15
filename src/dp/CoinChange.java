package dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        int val = dp[i - coins[j]];
                        dp[i] = Math.min(dp[i - coins[j]] + 1 , dp[i]);
                    }
                }
            }
        }
        return dp[dp.length-1] == Integer.MAX_VALUE ? -1 : dp[dp.length-1];
    }
}
