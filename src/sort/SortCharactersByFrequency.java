package sort;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;


public class SortCharactersByFrequency {
	
	public static void main(String[] args) {
		new SortCharactersByFrequency().frequencySort("Aabb");
	}
	
    public String frequencySortByStream(String s) {
    	char[] sArray = s.toCharArray();   	
    	Map<Character, StringBuilder> map = new HashMap<>();
    	for(int i = 0 ; i < sArray.length ; i++) {
    		if(map.containsKey(sArray[i])) {
    			StringBuilder str = map.get(sArray[i]);
    			str.append(sArray[i]);
    		} else {
    			StringBuilder str = new StringBuilder();
    			str.append(sArray[i]);
    			map.put(sArray[i], str);
    		}
    	}
    	  
    	List<StringBuilder> list = map.values().stream().sorted
    			(Comparator.comparing(StringBuilder::length))
    			.collect(Collectors.toList()); 
    	StringBuilder result = new StringBuilder();  
    	for(int i = list.size()-1 ; i >= 0 ; i--) {
    		result.append(list.get(i));
    	}   	
		return result.toString();       
    }
    
    public String frequencySort(String s) {
    	char[] sArray = s.toCharArray();   	
    	Map<Character, StringBuilder> map = new HashMap<>();
    	for(int i = 0 ; i < sArray.length ; i++) {
    		if(map.containsKey(sArray[i])) {
    			StringBuilder str = map.get(sArray[i]);
    			str.append(sArray[i]);
    		} else {
    			StringBuilder str = new StringBuilder();
    			str.append(sArray[i]);
    			map.put(sArray[i], str);
    		}
    	}
    	  
    	Map<Integer, StringBuilder> bucket = new HashMap<>(); 
    	for(Map.Entry<Character, StringBuilder> entry : map.entrySet()) {
    		int index = entry.getValue().length();
    		if(bucket.containsKey(index)) {
    			StringBuilder string = bucket.get(index);
    			string.append(entry.getValue());
    		} else {
    			bucket.put(index, entry.getValue());
    		}
    	}
    	StringBuilder result = new StringBuilder();  
    	for(int i = sArray.length ; i >= 0 ; i--) {
    		if(bucket.containsKey(i)) {
    			result.append(bucket.get(i));
    		}
    	}   	
		return result.toString();
        
    }
	

}
