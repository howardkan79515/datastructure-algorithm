package map;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = dp[i] - k;
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            int c = map.computeIfAbsent(dp[i], val->0);
            map.put(dp[i], c+1);
        }
        return result;
    }
}
