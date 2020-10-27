package sort;

import java.util.Random;

public class QuickSortII {
	
	public static void main(String[] args) {
		int[] input = new int[] {3,6,2,1,7,5};
		new QuickSortII().sortArray(input);
	}
	
	public int[] sortArray(int[] input) {
		sort(0, input.length-1, input);
		return input;
	}
	
	private int[] sort(int start, int end, int[] array) {
		if(start >= end) {
			return array;
		}
		int pivot = getPivot(start, end, array);
		sort(start, pivot-1, array);
		sort(pivot+1, end, array);
		return array;		
	}
	
	private int getPivot(int start, int end, int[] array) {
		Random rand = new Random();
		int pivotIndex = rand.nextInt((end - start) + 1) + start;
		//Get pivot by random index to prevent time complexity to O(n^2).
		int pivot = array[pivotIndex];
		int index = start;
		for(int i = start; i <= end ; i++) {
			if(pivot <= array[i]) {
				continue;
			} 
			int num = array[i];
			array[i] = array[index];
			array[index] = num;
			if(array[i] == pivot) {
				pivotIndex = i;
			} else if(array[index] == pivot) {
				pivotIndex = index;
			}
			index++;
		}
		array[pivotIndex] = array[index];
		array[index] = pivot;
		return index;		
	}

}
