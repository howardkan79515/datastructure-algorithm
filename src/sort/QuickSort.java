package sort;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] input = new int[] {3,6,2,1,7,5};
		new QuickSort().sortArr(input);
	}
	public int[] sortArr(int[] input) {
		quickSort(0, input.length-1, input);
		return input;
	}
	private void quickSort(int start, int end, int[] input) {
		if(start > end) {
			return;
		}
		int pivotIndex = getPivot(start, end, input);
		quickSort(start, pivotIndex-1, input);
		quickSort(pivotIndex+1, end, input);
	}
	private int getPivot(int start, int end, int[] input) {
		int pivot = input[end];
		int index = start-1;
		for(int i = start ; i < end ; i++) {
			if(pivot > input[i]) {
				index++;
				int move = input[index];
				input[index] = input[i];
				input[i] = move;
			} 
		}
		index++;
		int move = input[index];
		input[end] = move;
		input[index] = pivot;
		return index;
	}

}
