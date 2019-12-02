package map;

class MyHashMap<K, V> {
    
	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(24,31);
		map.put(58,35);
		map.put(59,88);
		map.remove(84);
		map.get(62);
		map.put(2,22);
		map.put(44,70);
		map.get(24);
	}
	
	private Entry<Integer, Integer>[] map;
	private int capacity = 1000;
	private int size = 0;


	/** Initialize your data structure here. */
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		map = (Entry<Integer, Integer>[]) new Entry[capacity];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = hash(key, map.length);
		if(map[index] == null) {
			map[index] = new Entry<Integer, Integer>(key, value, null);
		} else {
			for(Entry<Integer, Integer> entry = map[index] ; entry != null ; entry = entry.next) {
				if(new Integer(key).equals(entry.key)) {
					entry.value = value;
					break;
				} else if(entry != null && entry.next == null) {
					entry.next = new Entry<Integer, Integer>(key, value, null);
					break;
				}
			}			
		}
		size++;
	}



	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int index = hash(key, map.length);
		if(map[index] == null) {
			return -1;
		} else {
			Entry<Integer, Integer> entry = map[index];
			while(entry != null) {
				if(new Integer(key).equals(entry.key)) {
					return entry.value;
				}
				entry = entry.next;
			}
		}
		return -1;       
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int index = hash(key, map.length);
		Entry<Integer, Integer> now = map[index];
		Entry<Integer, Integer> head = new Entry<Integer, Integer>(null, null, null);
		Entry<Integer, Integer> prev = new Entry<Integer, Integer>(null, null, null);
		head.next = map[index];    
		prev = head;
		while(now != null) {   
			if(new Integer(key).equals(now.key)) {
				prev.next = now.next;
				break;
			}
			prev = now;
			now = now.next;
		}
		map[index] = head.next;
	}

	private int hash(Object key, int length) {
		int h;
		return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % length;
	}
	

	@SuppressWarnings("hiding")
	class Entry<K, V> {

		K key;


		V value;


		Entry<K, V> next;


		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}
}
