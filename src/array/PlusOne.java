package array;

import java.util.Arrays;

public class PlusOne {
	
	public static void main(String[] args) {
		new PlusOne().plusOne(new int[] {9,8,9}); 
	}
	
	public int[] plusOne(int[] digits) {
		int num = 1;
		for(int i = digits.length-1 ; i >= 0 ; i--) {
			 int sum = digits[i] + num == 10 ? 0 : digits[i] + num;
			 num = digits[i] + num == 10 ?  1 : 0; 
			 digits[i] = sum;
			 if(num == 0) {
				 break;
			 }
		}
		int[] result = digits;
		if(digits[0] == 0) {
			result = Arrays.copyOfRange(digits, 0, digits.length+1);
			result[0] = 1;
		}
		return result;
		
	}

}
