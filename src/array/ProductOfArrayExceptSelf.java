package array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] * left[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = nums[i] * right[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = right[i+1];
            } else if (i == nums.length-1) {
                nums[i] = left[i-1];
            } else {
                nums[i] = right[i+1]*left[i-1];
            }
        }
        return nums;
    }

}
