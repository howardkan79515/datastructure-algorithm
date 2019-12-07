package string;

public class IsSubsequence {
	
	public static void main(String[] args) {
		new IsSubsequence().isSubsequence("abc", "ahbgdc");
		new IsSubsequence().isSubsequence("axc", "ahbgdc");

	}
	
	public boolean isSubsequence(String s, String t) {
		
		char[] sArray = s.toCharArray();
		int formerIndex = 0;
		for(int i = 0 ; i < sArray.length ; i++) {
			int index = t.indexOf(sArray[i], formerIndex);
			if(index < formerIndex) {
				return false;
			}
			formerIndex = index+1;
		}		
		return true;        
    }

}
