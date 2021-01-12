package dfs;

public class WordSearch {

	public static void main(String[] args) {
		//		[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
		//				"ABCCED"
		//		[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
		//				"SEE"
		//		[["a","b"],["c","d"]]
		//				"cdba"
		//		[["A","B","C","E"],
		//		 ["S","F","E","S"],
		//		 ["A","D","E","E"]]
		//				"ABCESEEEFS"
		char[][] board = new char[][]{{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}};
			//char[][] board2 = new char[][]{{'a','b'},{'c','d'}};
			new WordSearch().exist(board, "ABCESEEEFS");
	}


	public boolean exist(char[][] board, String word) {
		char[] array = word.toCharArray();
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board[0].length ; j++) {
				boolean[][] state = new boolean[board.length+1][board[0].length+1];
				boolean result = dfs(board, array, i, j, 0, state);
				if(result) {
					return true;
				}
			}
		}
		return false;        
	}

	private boolean dfs(char[][] board, char[] array, int x, int y, int i, boolean[][] state) {
		if(!valid(board, x, y) || i > array.length-1 || state[x][y] || board[x][y] != array[i]) {
			i = 0;
			return false;
		} 
		i = i+1;
		state[x][y] = true;
		if(i == array.length) {
			i = 0;
			return true;
		}
		if(dfs(board, array, x+1, y, i, state)||
				dfs(board, array, x-1, y, i, state)||
				dfs(board, array, x, y+1, i, state)||
				dfs(board, array, x, y-1, i, state)) {
			return true;
		}
		state[x][y] = false;
		return false;
	}

	private boolean valid(char[][] board, int x, int y) {
		if(x > board.length-1 || y > board[0].length-1 || x < 0 || y < 0) {
			return false;
		}		
		return true;		
	}
}
