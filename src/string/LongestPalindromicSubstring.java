package string;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		//new LongestPalindromicSubstring().longestPalindrome("cbbd");
		new LongestPalindromicSubstring().longestPalindrome("babcb");
	}
	String result = "";
	
	public String longestPalindrome(String s) {
		if(s.length() == 0) {
			return result;
		}
		char[] array = s.toCharArray();
		result = result+array[0];
		for(int i = 0 ; i < s.length() ; i++) {
			recursion(s, array, i, s.length());
		}		
		return result;
		
	}

	private void recursion(String s, char[] array, int from , int to) {
		char c = array[from];
		int index = s.lastIndexOf(c, to);
		if(index == -1) {
			return;
		}
		boolean isPalindrome = isPalindrome(array, from , index);
		if(isPalindrome) {
			if(index+1-from > result.length()) {
				result = s.substring(from, index+1);
			}
			return;
		} 
		recursion(s, array, from, index-1);
	}
	

	
	private boolean isPalindrome(char[] array, int from, int to) {
		int j = 1;
		for(int i = from+1 ; i < to ; i++) {
			int index = to-j;
			if(array[i] != array[index]) {
				return false;
			}
			j++;
		}		
		return true;		
	}
	


}
