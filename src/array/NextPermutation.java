package array;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        boolean desc = true;
        int maxJ = -1;
        int maxI = -1;
        for (int i = nums.length-1; i >= 0; i--) {
            int indJ = -1;
            int indI = -1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    desc = false;
                    indJ = j;
                    indI = i;
                    break;
                }
            }
            if (indJ > maxJ) {
                maxJ = indJ;
                maxI = indI;
            }
        }
        if (desc) {
            Arrays.sort(nums);
            return;
        }
        int n = nums[maxJ];
        nums[maxJ] = nums[maxI];
        nums[maxI] = n;
        Arrays.sort(nums, maxJ+1, nums.length);
    }
}
