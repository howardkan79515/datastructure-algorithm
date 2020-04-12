package map;

public class HappyNumber {
	
	int count = 0;
	
	public static void main(String[] args) {
		new HappyNumber().isHappy(22);
	}
	
	public boolean isHappy(int n) {
		boolean result = doRecursion(n);
		return result;
	}

	private boolean doRecursion(int n) {
		int num = 0;
		count++;
		while(n > 0) {
			int d = n % 10; 
			n = n / 10;
			num = num + d * d;
		}
		if(num == 1) {
			return true;
		} else if (count > 5){
			return false;
		} else {
			return doRecursion(num);
		}
	}

}
