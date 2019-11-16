package sort;

public class InsertSort {
	
	public static void main(String[] args) {
		new InsertSort().sort(new int[] {5,4,3,2,1});
	}
	
	public int[] sort(int[] array) {
		for(int i = 1 ; i < array.length ; i++) {
			int val = array[i];
			int index = 0;
			boolean isInsert = false;
			for(int j = i-1 ; j >= 0 ; j--) {
				if(val < array[j]) {
					array[j+1] = array[j];
					index = j;
					isInsert = true;
				} else {
					break;
				}
			}
			if(isInsert) {
				array[index] = val;
			}
		}		
		return array;
	}

}
