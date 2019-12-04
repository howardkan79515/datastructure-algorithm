package trie;



public class Trie {
	
   public static void main(String[] args) {
	   Trie trie = new Trie();
	   trie.insert("apple");
	   trie.insert("app");
	   trie.search("app");
   }
	
   TrieNode[] children;
	
	 /** Initialize your data structure here. */
   public Trie() {
   	children = new TrieNode[26];
   }
   
   public void insert(String word) {
   	char[] charArray = word.toCharArray();
   	children = buildChildNodes(children, charArray, 0);
   }
   
   private TrieNode[] buildChildNodes(TrieNode[] children, char[] charArray, int i) {
	   if(i > charArray.length-1) {
		   return null;
	   }
	   char value = charArray[i];
	   int index = value - 'a';
	   i++;
	   children = children == null ? new TrieNode[26] : children;
	   TrieNode node = children[index];
	   if(node == null) {
		   node = new TrieNode(value);
		   children[index] = node;
	   } 
	   if(i == charArray.length) {
		   node.isEndingChar = true;
		   return children;
	   }
	   
	   node.children = buildChildNodes(node.children, charArray, i);
	   return children;
   }
   
   /** Returns if the word is in the trie. */
   public boolean search(String word) {
	   char[] wordArray = word.toCharArray();
	   boolean result = searchTrie(children, wordArray, 0);
	   return result;        
   }
   
   private boolean searchTrie(TrieNode[] children, char[] wordArray, int i) {
	   if(i > wordArray.length-1) {
		   return false;
	   }
	   char value = wordArray[i];
	   int index = value - 'a';
	   TrieNode node = children[index];
	   i++;
	   if(node == null) {
		   return false;
	   } else if (node.isEndingChar && i == wordArray.length){
		   return true;
	   } else if (node.children != null){
		   return searchTrie(node.children, wordArray, i);
	   }
	   return false;
   }
   
   public boolean startsWith(String prefix) {
	   char[] prefixArray = prefix.toCharArray();
	   boolean result = checkStartsWith(children, prefixArray, 0);
	   return result;       
   }
   
   private boolean checkStartsWith(TrieNode[] children, char[] wordArray, int i) {
	   if(i > wordArray.length - 1) {
		   return false;
	   }
	   char value = wordArray[i];
	   int index = value - 'a';
	   TrieNode node = children[index];
	   i++;
	   if(node == null) {
		   return false;
	   } else if(i == wordArray.length) {
		   return true;
	   } else if (node.children != null){
		   return checkStartsWith(node.children, wordArray, i);
	   }
	   return false;
   }
   
   public class TrieNode {

	   char value;

	   TrieNode[] children = new TrieNode[26];

	   boolean isEndingChar = false;

	   public TrieNode(char value) {
		   this.value = value;
	   }
	   
   }
   

}
