package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        int prev = nums[0];
        int start = prev;
        List<String> result = new ArrayList<>();
        StringBuilder range = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev+1) {
                range.append(start);
                if (start != prev) {
                    range.append("->");
                    range.append(prev);
                }
                result.add(range.toString());
                range = new StringBuilder();
                start = nums[i];
            }
            prev = nums[i];
        }
        range.append(start);
        if (start != prev) {
            range.append("->");
            range.append(prev);
        }
        result.add(range.toString());
        return result;
    }
}
