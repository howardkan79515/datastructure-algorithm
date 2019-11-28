package heap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
//		new TopKFrequentWords().topKFrequent(
//				new String[] {"a","aa","aaa"}, 2);
//		new TopKFrequentWords().topKFrequent(
//				new String[] {"the", "day", "is", "sunny", "the", 
//						"the", "the", "sunny", "is", "is"}, 4);
		new TopKFrequentWords().topKFrequent(
				new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
			

	}


	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> freqMap = new HashMap<>();
		for(String word : words) {
			if(freqMap.containsKey(word)) {
				Integer freq = freqMap.get(word);
				freq++;
				freqMap.replace(word, freq);
			} else {
				freqMap.put(word, 1);			
			}
		}
		PriorityQueue<Map.Entry<String, Integer>> priorityQueue = 
				new PriorityQueue<>(new FreqComparator());				
		for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			priorityQueue.offer(entry);
		}
		List<String> result = new ArrayList<>(k);
		int size = priorityQueue.size();
		for(int i = 0 ; i < k ; i++) {
			String string = priorityQueue.poll().getKey();
			
				result.add(string);
			
		}
		//Collections.reverse(result);
		return result;

	}
	
	class FreqComparator implements Comparator<Map.Entry<String, Integer>>{       
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			// TODO Auto-generated method stub
			if(!o1.getValue().equals(o2.getValue())) {
				return o2.getValue() - o1.getValue();
			}
			return o1.getKey().compareTo(o2.getKey());
		}
	}

}


