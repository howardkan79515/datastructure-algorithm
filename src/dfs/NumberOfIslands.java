package dfs;


public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] array = new char[][]{
		  	{'1','1','0','0','0'},
		  	{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
		};
		char[][] array2 = new char[][]{{'1','0','1','1','0','1','1'}};
		new NumberOfIslands().numIslands(array);
		new NumberOfIslands().numIslands(array2);
	}

	public int numIslands(char[][] grid) {
		int result = 0;
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[0].length ; j++) {
				result = result + dfs(grid, i , j);
			}
		}
		return result;
        
    }
	
	private int dfs(char[][] array, int x, int y) {
		if(over(array, x, y) || array[x][y] == '0') {
			return 0;
		}
		array[x][y] = '0';
		dfs(array, x+1, y);
		dfs(array, x-1, y);
		dfs(array, x, y+1);
		dfs(array, x, y-1);
		return 1;		
	}
	
	private boolean over(char[][] array, int x, int y) {
		if(x < 0 || y < 0 || x >= array.length || y >= array[0].length) {
			return true;
		}
		return false;
	}
	
	class Index {
		int x;
		int y;		
		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
	    public boolean equals(Object that) {
	        if(that instanceof Index) {
	        	Index p = (Index) that;
	            return this.x == p.x && this.y == p.y;
	        }
	        return false;
	    }
		
		@Override
	    public int hashCode() {
	        return 41 * (41 + x) + y;
	    }
	}
}
