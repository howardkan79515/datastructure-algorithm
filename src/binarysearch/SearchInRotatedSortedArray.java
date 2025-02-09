package binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (target == nums[0]) {
            return 0;
        }
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (nums[i-1] > nums[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        int s = index;
        int e = nums.length-1;
        while (s <= e) {
            int mid = e + (s-e)/2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
