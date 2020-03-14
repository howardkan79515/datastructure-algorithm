



package stack;

import java.util.Stack;


public class DecodeString {
	
	public static void main(String[] args) {
		new DecodeString().decodeString("100[leetcode]");
		new DecodeString().decodeString("3[a]2[bc]");
		new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
		new DecodeString().decodeString("3[a2[c]]");
	}
	public String decodeString(final String s) {
		char[] sArr  = s.toCharArray();
		Stack<String> resutStack = new Stack<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = sArr[i];
			if (c == ']') {
				StringBuilder val = getAlphabet(resutStack); 
				int num = getNumber(resutStack);
				StringBuilder mulVal = new StringBuilder();
				for(int j = 0 ; j < num ; j++) {
					mulVal.append(val);
				}
				resutStack.add(mulVal.toString());
			} else {
				resutStack.add(String.valueOf(c));
			}			
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i < resutStack.size() ; i++) {
			result.append(resutStack.get(i));
		}
		return result.toString();

	}
	private StringBuilder getAlphabet(Stack<String> resutStack) {
		StringBuilder val = new StringBuilder();				
		while (true){
			String v = resutStack.pop();
			if(v.equals("[")) {
				break;
			}
			val.insert(0, v);
		}
		return val;
	}
	private int getNumber(Stack<String> resutStack) {
		StringBuilder numBuilder = new StringBuilder();
		while (!resutStack.isEmpty()){
			String v = resutStack.pop();
			if(!isNumeric(v)) {
				resutStack.add(v);
				break;
			}
			numBuilder.insert(0, v);
		}
		int num = Integer.valueOf(numBuilder.toString());
		return num;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	

}
