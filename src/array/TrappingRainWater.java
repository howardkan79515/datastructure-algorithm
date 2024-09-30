package array;

public class TrappingRainWater {

    public int trap(int[] height) {
        int res = 0;
        int[] right = new int[height.length+1];
        int max = height[height.length-1];
        for (int i = right.length-2; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        int prevMax = height[0];
        for (int i = 1; i < height.length-1; i++) {
            int h = Math.min(prevMax, right[i]);
            res += h - height[i] <= 0 ? 0 : h - height[i];
            prevMax = Math.max(prevMax, height[i]);
        }
        return res;
    }
}
