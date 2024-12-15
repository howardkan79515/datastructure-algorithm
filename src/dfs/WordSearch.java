package dfs;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][]{{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}};
			new WordSearch().exist(board, "ABCEFSADEESE");
	}


	public boolean exist(char[][] board, String word) {
		char first = word.charAt(0);
		char[] wArray = word.toCharArray();
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[j].length; i++) {
				if (first == board[j][i]) {
					boolean[][] cache = new boolean[board.length][board[0].length];
					if (dfs(board, wArray, i, j, 0, cache)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, char[] wArray, int i, int j, int k, boolean[][] cache) {
		if (i >= board[0].length || j >= board.length || i < 0 || j < 0) {
			return false;
		}
		if (board[j][i] != wArray[k]) {
			return false;
		}
		if (cache[j][i]) {
			return false;
		}
		if (k == wArray.length-1) {
			return true;
		}
		cache[j][i] = true;
		if (dfs(board, wArray, i+1, j, k+1, cache) || dfs(board, wArray, i, j+1, k+1, cache) ||
				dfs(board, wArray, i-1, j, k+1, cache) || dfs(board, wArray, i, j-1,k+1, cache)) {
			return true;
		}
		cache[j][i] = false;
		return false;
	}
}
