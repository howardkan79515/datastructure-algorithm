package map;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);	
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);
		cache.get(1);
		cache.get(2);
	}

	Map<Integer, Integer> cache;

	int capacity;

	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<>(capacity, .75f, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.size() >= capacity) {
			if (!cache.containsKey(key)) {
				for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
					cache.remove(entry.getKey());
					break;
				}
			}
		}
		cache.put(key, value);
	}

}
