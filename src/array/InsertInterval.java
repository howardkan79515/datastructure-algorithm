package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Set<int[]> list = new LinkedHashSet<>();
        if (intervals.length == 0) {
            list.add(newInterval);
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (newInterval[1] < start) {
                list.add(newInterval);
                list.add(interval);
            } else if (newInterval[0] > end) {
                list.add(interval);
                list.add(newInterval);
            } else {
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(newInterval[1], end);
                list.add(newInterval);
            }
        }
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] val : list) {
            res[i] = val;
            i++;
        }
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        return res;
    }
}
