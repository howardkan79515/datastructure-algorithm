package string;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
	
	public static void main(String[] args) {
		new GroupAnagrams().groupAnagrams(new String[] {
		"eat", "tea", "tan", "ate", "nat", "bat"});
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groupMap = new HashMap<>(); 
		for(int i = 0 ; i < strs.length ; i++) {
			String sortedString = sortedString(strs[i]);
			if(!groupMap.containsKey(sortedString)) {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				groupMap.put(sortedString, list);
			} else {
				List<String> list = groupMap.get(sortedString);
				list.add(strs[i]);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
			result.add(entry.getValue());			
		}
		return result;        
    }
	
	private String sortedString(String anagram) {
		char[] array = anagram.toCharArray();
		Arrays.sort(array);
		String result = new String(array);
		return result;
		
	}

}
