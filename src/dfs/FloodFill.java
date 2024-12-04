package dfs;

public class FloodFill {
	
	public static void main(String[] args) {
		new FloodFill().floodFill(new int[][]{{0,0,0},{0,1,1}},
				1, 1, 1);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int target = image[sr][sc];
		dfs(image, sr, sc, color, target);
		return image;
	}


	private void dfs(int[][] image, int sr, int sc, int color, int target) {
		if (sr > image.length-1 || sc > image[0].length-1 || sr < 0 || sc < 0) {
			return;
		}
		if (image[sr][sc] != target || image[sr][sc] == color) {
			return;
		}
		image[sr][sc] = color;
		dfs(image, sr+1, sc, color, target);
		dfs(image, sr, sc+1, color, target);
		dfs(image, sr-1, sc, color, target);
		dfs(image, sr, sc-1, color, target);
	}

}
