package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        new SpiralMatrix().spiralOrder(new int[][] {new int[] {1,2,3}, new int[] {4,5,6}, new int[] {7,8,9}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int maxI = matrix[0].length-1;
        int maxJ = matrix.length-1;
        int minI = 0;
        int minJ = 0;
        int step = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        int direction = 0;
        int[][] d = new int[][] {new int[] {1, 0},
                new int[]{0, 1}, new int[] {-1, 0}, new int[]{0, -1}};
        List<Integer> res = new ArrayList<>();
        while (step > 0) {
            res.add(matrix[j][i]);
            if (direction == 0 && i == maxI && j == minJ) {
                direction = 1;
                minJ++;
            } else if (direction == 1 && j == maxJ && i == maxI) {
                direction = 2;
                maxI--;
            } else if (direction == 2 && i == minI && j == maxJ) {
                direction = 3;
                maxJ--;
            } else if (direction == 3 && j == minJ && i == minI) {
                direction = 0;
                minI++;
            }
            i += d[direction][0];
            j += d[direction][1];
            step--;
        }
        return res;
    }
}
