package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int prev = lower;
        if (nums.length == 0) {
            return List.of(List.of(lower, upper));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && prev != nums[i]) {
                result.add(List.of(prev, nums[i]-1));
            } else {
                if (nums[i] - prev > 1) {
                    result.add(List.of(prev + 1, nums[i]-1));
                }
            }
            prev = nums[i];
        }
        if (upper != prev) {
            result.add(List.of(prev + 1, upper));
        }
        return result;
    }

}
