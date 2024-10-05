package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShuffleArray {

    int[] nums;

    int[] copy;

    Set<Integer> movedIndexes = new HashSet<>();

    Random rand = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.copy = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
}
