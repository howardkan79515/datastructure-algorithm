package sort;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
	
	public static void main(String[] args) {
		new IntersectionOfTwoArraysII().intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4});
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] shortArray = nums1.length < nums2.length ? nums1 : nums2;
		int[] longArray = nums2.length > nums1.length ? nums2 : nums1;
		int shortIndex = 0;
		int longIndex = 0;
		int[] result = new int[shortArray.length];
		int index = 0;
		while(shortIndex < shortArray.length && longIndex < longArray.length) {
			if(shortArray[shortIndex] == longArray[longIndex]) {
				result[index] = shortArray[shortIndex];
				index++;
				shortIndex++;
				longIndex++;
			} else if(shortArray[shortIndex] > longArray[longIndex]) {
				longIndex++;
			} else if(shortArray[shortIndex] < longArray[longIndex]) {
				shortIndex++;
			}
		}
		int[] finResult = Arrays.copyOfRange(result, 0, index);
		return finResult;
        
    }

}
