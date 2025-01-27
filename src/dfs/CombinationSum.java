package dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(int[] candidates, int i, List<Integer> ans, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            ans.add(candidates[j]);
            dfs(candidates, j, ans, sum + candidates[j], target);
            ans.remove(ans.size()-1);
        }
    }

    List<List<Integer>> res = new ArrayList<>();
}
