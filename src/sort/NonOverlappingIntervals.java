package sort;

import java.util.*;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}});
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare by the first element
            } else {
                return Integer.compare(a[1], b[1]); // If first elements are the same, compare by second element
            }
        });
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            for (int j = i+1; j < intervals.length; j++) {
                int[] next = intervals[j];
                if (interval[1] > next[0]) {
                    result++;
                    if (interval[1] > next[1]) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
