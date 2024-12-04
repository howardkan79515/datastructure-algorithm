package trie;



public class Trie {
	
   public static void main(String[] args) {
	   Trie trie = new Trie();
	   trie.insert("apple");
	   trie.insert("app");
	   trie.search("app");

   }

	public Trie() {
	}

	TrieNode[] nodes = new TrieNode[26];

	public void insert(String word) {
		insert(nodes, 0, word);
	}

	private void insert(TrieNode[] nodes, int i, String word) {
		if (i >= word.length()) {
			return;
		}
		char c = word.charAt(i);
		int num = c - 'a';
		TrieNode node = nodes[num];
		if (node == null) {
			node = new TrieNode(num);
			nodes[num] = node;
		}
		if (i == word.length()-1) {
			node.end = true;
		}
		insert(node.children, i+1, word);
	}

	public boolean search(String word) {
		return search(nodes, word, 0);
	}

	private boolean search(TrieNode[] nodes, String word, int i) {
		if (i >= word.length()) {
			return false;
		}
		char c = word.charAt(i);
		int num = c - 'a';
		TrieNode node = nodes[num];
		if (node == null) {
			return false;
		}
		if (i == word.length()-1) {
			if (node.end) {
				return true;
			}
		}
		return search(node.children, word, i+1);
	}

	public boolean startsWith(String prefix) {
		return startsWith(nodes, prefix, 0);
	}

	private boolean startsWith(TrieNode[] nodes, String prefix, int i) {
		if (i >= prefix.length()) {
			return false;
		}
		char c = prefix.charAt(i);
		int ind = c - 'a';
		TrieNode node = nodes[ind];
		if (node == null) {
			return false;
		} else if (node.value == -1){
			return false;
		} else if (node.value != -1 && i == prefix.length()-1){
			return true;
		}
		return startsWith(node.children, prefix, i+1);
	}

	public class TrieNode {
		boolean end = false;

		int value = -1;

		TrieNode[] children = new TrieNode[26];

		TrieNode(int value) {
			this.value = value;
		}
	}
   

}
