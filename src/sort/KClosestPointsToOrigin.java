package sort;

import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int mul = p[0]*p[0] + p[1]*p[1];
            List<int[]> list = map.computeIfAbsent(mul, key -> new ArrayList<>());
            list.add(p);
        }
        int j = 0;
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> tops = entry.getValue();
            for (int[] top : tops) {
                if (j < k) {
                    res[j] = top;
                    j++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int[][] kClosestII(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                int dis = a[0]*a[0]+a[1]*a[1];
                int disb = b[0]*b[0]+b[1]*b[1];
                return dis - disb;
            }
        }
        );
        for(int i = 0 ; i < points.length ; i++) {
            heap.add(points[i]);
        }
        int[][] result = new int[K][2];
        for(int i = 0 ; i < K ; i++) {
            result[i] = heap.poll();
        }
        return result;

    }
}
