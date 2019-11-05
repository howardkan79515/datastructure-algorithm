package sort;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] input = new int[] {3,6,2,1,7,5};
		new MergeSort().sortArray(input);
	}
	
	
	public int[] sortArray(final int[] nums) {
		if(nums.length < 2) {
			return nums;
		}
		int mid = nums.length/2; 
		int[] left = new int[mid]; 
		int[] right = new int[nums.length - mid];
		for(int i = 0 ; i < nums.length ; i++) {
			if(i < mid) {
				left[i] = nums[i];
			} else {
				right[i-mid] = nums[i];
			}
		}
		sortArray(left);
		sortArray(right);
		return merge(left, right, nums);
	} 
	
	
	private int[] merge(final int[] left, final int[] right, final int[] input) {
		int mergeLength = left.length + right.length;
		int leftCount = 0;
		int rightCount = 0;
		for(int i = 0 ; i < mergeLength ; i++) {
			if((leftCount == left.length) || (rightCount == right.length)) {
				break;
			}
			if(left[leftCount] < right[rightCount]) {
				input[i] = left[leftCount];
				leftCount++;
			} else if (left[leftCount] > right[rightCount]) {
				input[i] = right[rightCount];
				rightCount++;
			}
		}
		int start = 0;
		int[] arr = null;
		if(leftCount != left.length) {
			start = leftCount;
			arr = left;
		} else {
			start = rightCount;
			arr = right;
		}
		int count = leftCount + rightCount;
		for(int i = start ; i < arr.length ; i++) {
			input[count] = arr[i];
			count++;
		}
		return input;
	}
}
