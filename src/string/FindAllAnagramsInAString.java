package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
	
	public static void main(String[] args) {
		new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc");
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		char[] sArray = s.toCharArray();
		String sortedP = sortString(p);
		List<Integer> result = new ArrayList<>();
		for(int i = 0 ; i+p.length() <= sArray.length ; i++) {
			char[] subArray = Arrays.copyOfRange(sArray, i, i+p.length());
			String sortedString = sortString(subArray);
			if(String.valueOf(sortedP).equals(sortedString)) {
				result.add(i);
			}
		}
		return result;
		
	}
	
	private String sortString(char[] array) {
		Arrays.sort(array);
		String result = new String(array);
		return result;		
	}
	
	private String sortString(String str) {
		char[] array = str.toCharArray();
		Arrays.sort(array);
		String result = new String(array);
		return result;		
	}

}
