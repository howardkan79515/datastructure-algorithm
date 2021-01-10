package string;

public class ValidPalindromeII {
	
	public static void main(String[] args) {
		new ValidPalindromeII().validPalindrome("cbbcc");
	}
	
	public boolean validPalindrome(String s) {
		boolean result = dfs(s.toCharArray(), 0, s.length()-1, false);
		return result;       
	}
	
	private boolean dfs(char[] chars, int i, int j, boolean deleted) {
		if(i >= j) {
			return true;
		}
		boolean res1 = false, res2= false, res3 = false;
		if(chars[i] == chars[j]) {
			res1 = dfs(chars, i+1, j-1, deleted);
		} else if(chars[i] != chars[j] && !deleted) {
			deleted = true;
			res2 = dfs(chars, i+1, j, deleted);
			res3 = dfs(chars, i, j-1, deleted);
		} else if(chars[i] != chars[j] && deleted) {
			return false;
		}			
		return res1 || res2 || res3;		
	}

	

}
