package search;

public class ValidPerfectSquare {
	
	public static void main(String[] args) {
		//new ValidPerfectSquare().isPerfectSquare(16);
		
		new ValidPerfectSquare().isPerfectSquare(2147483647);
	}
	
	public boolean isPerfectSquare(int num) {
		long left = 0;
		long right = num;
		
		while(left <= right) {
			long index = (left+right)/2;
			long square = index * index;
			if(square > num) {
				right = index-1;
			} else if (square < num){
				left = index+1;
			} else {
				return true;
			}
		}
		
		System.out.print("re");
		return false;
        
    }

}
