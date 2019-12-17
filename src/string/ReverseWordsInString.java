package string;

public class ReverseWordsInString {
	
	public static void main(String[] args) {
		new ReverseWordsInString().reverseWords("");
		new ReverseWordsInString().reverseWords("the sky is blue");
		new ReverseWordsInString().reverseWords("  hello world!  ");
	}
	
	public String reverseWords(String s) {
		String[] aArray = s.split(" ");
		StringBuilder result = new StringBuilder(); 
		for(int i = aArray.length - 1 ; i >= 0 ; i--) {
			if(!aArray[i].equals("")) {
				result.append(aArray[i]);
				result.append(" ");				
			}			
		}
		if(result.length() != 0) {
			result.setLength(result.length()-1);
	    }
		return result.toString();        
    }
}
