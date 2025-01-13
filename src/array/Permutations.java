package array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        result.add(arr);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                List<Integer> sub = result.get(j);
                for (int k = 0; k < sub.size()+1; k++) {
                    List<Integer> newSub = new ArrayList<>(sub);
                    newSub.add(k, nums[i]);
                    newResult.add(newSub);
                }
            }
            result = newResult;
        }
        return result;
    }
}
