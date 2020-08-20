package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
	
	public static void main(String[] args) {
		int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
		//int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
		//int[][] grid = new int[][]{{1,2,1,1,2,1,1}};
		new RottingOranges().orangesRotting(grid);
		
	}
	
	Set<List<Integer>> cache = new HashSet<>();
	
	public int orangesRotting(int[][] grid) {
		Queue<List<Integer>> rottenIndex = new LinkedList<>();
		int freshCount = 0;
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					freshCount++;
				} else if(grid[i][j] == 2) {
					rottenIndex.add(Arrays.asList(i, j));
				}
			}
		}
		int result = bfs(grid, rottenIndex);
		if(freshCount > cache.size()) {
			return -1;
		}
		return result;       
    }
	
	private int bfs(int[][] grid, Queue<List<Integer>> rottenIndex) {
		int[][] move = new int[][] {{1, -1, 0, 0}, {0, 0, 1, -1}};
		int result = 0;
		rottenIndex.add(null);
		while (!rottenIndex.isEmpty()) {
			List<Integer> rotten = rottenIndex.poll();
			if(rotten == null) {
				if(rottenIndex.isEmpty()) {
					break;
				}
				result++;
				rottenIndex.add(null);
				continue;
			}
			int i = rotten.get(0);
			int j = rotten.get(1);
			grid[i][j] = 2;
			for(int z = 0 ; z < 4 ; z++) {
				int x = i + move[0][z];
				int y = j + move[1][z];
				List<Integer> xy = Arrays.asList(x, y);
				if(!over(grid, x, y) && grid[x][y] == 1 && !cache.contains(xy)) {
					rottenIndex.add(xy);
					cache.add(xy);
				}
			}
		}
		return result;		
	}
	
	private boolean over(int[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return true;
		}
		return false;		
	}

}
