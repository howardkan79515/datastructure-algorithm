package string;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {		
		new WordBreak().wordBreak("cars", Arrays.asList
						("car","ca","rs"));
		new WordBreak().wordBreak("catsandog", Arrays.asList
				("cats", "dog", "sand", "and", "cat"));
		new WordBreak().wordBreak("applepenapple", 
				Arrays.asList("apple", "pen"));
		new WordBreak().wordBreak("a", 
				Arrays.asList("b"));
		new WordBreak().wordBreak("bb", 
				Arrays.asList("a","b","bbb","bbbb"));
	}
	
	
	
	boolean result = false;
	public boolean wordBreak(String s, List<String> wordDict) {
		if(wordDict.size() == 0) {
			return false;
		}
		char[] sArray = s.toCharArray();
		Set<String> set = getDictSet(wordDict);
		int[] dp = new int[s.length()]; 
		Arrays.fill(dp, -1);
		for(int i = 0 ; i < sArray.length ; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = i ; j >= 0 ; j--) {
				sb.insert(0, sArray[j]);
				if(!set.contains(sb.toString())) {
					continue;
				}
				if(j == 0) {
					dp[i] = 1;
				} else if(dp[j-1] != -1) {
					dp[i] = dp[j-1]+1;
					break;//
				}
			}
		}
		return dp[dp.length-1] == -1 ? false : true;
        
    }
	private Set<String> getDictSet(List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for(String word : wordDict) {
			set.add(word);
		}
		return set;
	}
	
}
