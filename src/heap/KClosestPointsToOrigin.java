package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	
	public static void main(String[] args) {
		new KClosestPointsToOrigin().kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2);
	}
	
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]> () {
			public int compare(int[] a, int[] b) {
				int dis = a[0]*a[0]+a[1]*a[1];
				int disb = b[0]*b[0]+b[1]*b[1];
				return dis - disb;
			}
		});
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
