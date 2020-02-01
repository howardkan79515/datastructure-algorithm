package string;

public class AddBinary {
	
	public static void main(String[] args) {
		new AddBinary().addBinary("1010",
				"1011");
	}
	
	public String addBinary(String a, String b) {		
		char[] longArr = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
		char[] shortArr = b.length() < a.length() ? b.toCharArray() : a.toCharArray();
		int diff = longArr.length - shortArr.length;
	    int carryNum = 0;
	    StringBuilder result = new StringBuilder();
		for(int i = longArr.length-1 ; i >= 0 ; i--) {
			int num = i-diff >= 0 ? shortArr[i-diff] - '0' : 0;
			int addedNum = longArr[i] - '0';
			int ans = num + addedNum + carryNum;
			if(ans < 2) {
				carryNum = 0;
				result.append(ans);
			} else if(ans == 2) {
				carryNum = 1;
				result.append(0);
			} else if(ans == 3) {
				carryNum = 1;
				result.append(1);
			}			
		}		
		if(carryNum == 1) {
			result.append(1);
		}		
		return result.reverse().toString();		
	}

}
