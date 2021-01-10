package string;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		new ValidPalindrome().isPalindrome
		("0P");
		new ValidPalindrome().isPalindrome
		("A man, a plan, a canal: Panama");
	}
	
	public boolean isPalindrome(String s) {
		int j = s.length()-1;
		int i = 0;
		while(i < s.length()) {
			if(!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if(!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if(Character.toLowerCase(s.charAt(i)) != 
					Character.toLowerCase(s.charAt(j))) {
				return false;
			}
            if(i >= j) {
                break;
            }
			j--;
			i++;
		}		
		return true;
	}

}
