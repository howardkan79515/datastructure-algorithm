package dfs;

public class FloodFill {
	
	public static void main(String[] args) {
		new FloodFill().floodFill(new int[][]{{0,0,0},{0,1,1}},
				1, 1, 1);
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int origColor = image[sr][sc];
		if(origColor == newColor) {
			return image;
		}
		fill(origColor, newColor, image, sr, sc);
		return image;       
    }
	
	private void fill(int origColor, int newColor, int[][] image, int sr, int sc) {
		if(isOver(image, sr, sc)) {
			return;
		}
		if(image[sr][sc] != origColor) {
			return;
		}
		image[sr][sc] = newColor;
		fill(origColor, newColor, image, sr+1, sc);
		fill(origColor, newColor, image, sr-1, sc);
		fill(origColor, newColor, image, sr, sc+1);
		fill(origColor, newColor, image, sr, sc-1);
	}
	
	private boolean isOver(int[][] image, int sr, int sc) {
		int x = image.length;
		int y = image[0].length;
		if(sr >= x || sc >= y || sr < 0 || sc < 0) {
			return true;
		}
		return false;	
	}

}
