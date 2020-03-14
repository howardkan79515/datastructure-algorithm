



package stack;

import java.util.Stack;


public class DecodeString {
	
	public static void main(String[] args) {
		//new DecodeString().decodeString("100[leetcode]");
		//new DecodeString().decodeString("3[a]2[bc]");
		//new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
		new DecodeString().decodeString("3[a2[c]]");
	}
	public String decodeString(final String s) {
		char[] sArr  = s.toCharArray();
		Stack<String> resutStack = new Stack<>();
		//Stack<Integer> numStack = new Stack<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = sArr[i];
			if(c == '[') {
				resutStack.add(String.valueOf(c));
			} else if (Character.isDigit(c)) {
				int num = Integer.parseInt(String.valueOf(c));
				resutStack.add(String.valueOf(c));
				//numStack.add(num);
			} else if (c == ']') {
				StringBuilder val = new StringBuilder();				
				while (true){
					String v = resutStack.pop();
					if(v.equals("[")) {
						break;
					}
					val.insert(0, v);
				} 
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
				StringBuilder r = new StringBuilder();
				for(int j = 0 ; j < num ; j++) {
					r.append(val);
				}
				resutStack.add(r.toString());

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
	
	public String decodeStringI(final String s) {
		char[] sArr  = s.toCharArray();
		Stack<String> resutStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = sArr[i];
			if(c == '[') {
				resutStack.add(String.valueOf(c));
			} else if (Character.isDigit(c)) {
				int num = Integer.parseInt(String.valueOf(c));
				numStack.add(num);
			} else if (c == ']') {
				StringBuilder val = new StringBuilder();
				while (true){
					String v = resutStack.pop();
					if(v.equals("[")) {
						break;
					}
					val.append(v);
				} 
//				StringBuilder numBuilder = new StringBuilder();
//				while (!resutStack.isEmpty()){
//					String v = resutStack.pop();
//					if(!isNumeric(v)) {
//						resutStack.add(v);
//						break;
//					}
//					numBuilder.append(v);
//				}
				int num = numStack.pop();
				String valString = val.reverse().toString();
				StringBuilder r = new StringBuilder();
				for(int j = 0 ; j < num ; j++) {
					r.append(valString);
				}
				resutStack.add(r.toString());

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

}
