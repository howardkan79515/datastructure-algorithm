package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	
	public static void main(String[] args) {
		new MinimumIndexSumOfTwoLists().findRestaurant(
				new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, 
				new String[] {"KFC", "Shogun", "Burger King"}); 
		new MinimumIndexSumOfTwoLists().findRestaurant(
				new String[] {"Shogun","Tapioca Express","Burger King","KFC"}, 
				new String[] {"KFC","Burger King","Tapioca Express","Shogun"}); 
		new MinimumIndexSumOfTwoLists().findRestaurant(
				new String[] {"k","KFC"}, 
				new String[] {"k","KFC"}); 


	
	}
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map1 = new HashMap<>();
		for(int i = 0 ; i < list1.length ; i++) {
				map1.put(list1[i], i);
		}
		int min = list1.length + list2.length;
		String[] result = new String[min];
		int i = 1;
		for(int j = 0 ; j < list2.length ; j++) {
			String key = list2[j];
			if(map1.containsKey(key)) {
				int index = j + map1.get(key);
				if(index < min) {
					result[i-1] = key;
					min = index;
				} else if (index == min) {
					i++;
					result[i-1] = key;
					min = index;
				}
			}
		}
		result = Arrays.copyOf(result, i);
		return result;       
    }

}
