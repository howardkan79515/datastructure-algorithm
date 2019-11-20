package map;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		for (Map.Entry<Integer, Integer> e : cache.getEntry()) {
			System.out.println(e.getKey());
		}
	}
	
	public Set<Entry<Integer, Integer>> getEntry() {
		return this.cache.entrySet();
	}
	
	private Map<Integer, Integer> cache;
	
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
    	int result = this.cache.get(key) == null ? -1 :
    		this.cache.get(key);
		return result;        
    }
    
    public void put(int key, int value) {
    	if(this.cache.size() >= this.capacity && 
    	  !this.cache.containsKey(key)) {
    		for (Map.Entry<Integer, Integer> e : cache.entrySet()) {
    			cache.remove(e.getKey());
    			break;
    		}
    	}
        this.cache.put(key, value);
    }

}
