package bfs;

import java.util.*;

public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
        char[][] maze = new char[][] {
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','+','+','+','+','.','+'}};
        int[] entrance = new int[] {0,1};
        new NearestExitFromEntranceInMaze()
                .nearestExit(maze, entrance);

        char[][] maze2 = new char[][] {
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','.','.','+'},
                {'+','+','+','+','.','+','.'}};
        int[] entrance2 = new int[] {0,1};
        new NearestExitFromEntranceInMaze()
                .nearestExit(maze2, entrance2);

    }

    class Pos {
        int x;
        int y;
        int c;
        Pos (int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // If the same object, they are equal
            if (o == null || getClass() != o.getClass()) return false; // Null or different class means not equal
            Pos pos = (Pos) o; // Cast to Pos
            return x == pos.x && y == pos.y; // Compare x and y values
        }

        // Override hashCode() to generate hash based on x and y values
        @Override
        public int hashCode() {
            return Objects.hash(x, y); // Generate hash using x and y
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(entrance[0], entrance[1], 0));
        boolean begin = true;
        Set<Pos> cache = new HashSet<>();
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            Pos position = new Pos(pos.x, pos.y, pos.c);
            if (cache.contains(position)) {
                continue;
            }
            cache.add(position);
            if (!begin) {
                if (maze[pos.x][pos.y] == '.' && (pos.x == 0 || pos.x == maze.length-1)) {
                    return pos.c;
                } else if (maze[pos.x][pos.y] == '.' && (pos.y == 0 || pos.y == maze[0].length-1)) {
                    return pos.c;
                }
            }
            begin = false;
            int upX = pos.x-1;
            int upY = pos.y;
            if (upX >= 0 && maze[upX][upY] == '.' ) {
                queue.add(new Pos(upX, upY, pos.c+1));
            }
            int downX = pos.x+1;
            int downY = pos.y;
            if (downX <= maze.length-1 && maze[downX][downY] == '.') {
                queue.add(new Pos(downX, downY, pos.c+1));
            }
            int rightX = pos.x;
            int rightY = pos.y+1;
            if (rightY <= maze[0].length-1 && maze[rightX][rightY] == '.') {
                queue.add(new Pos(rightX, rightY, pos.c+1));
            }
            int leftX = pos.x;
            int leftY = pos.y-1;
            if (leftY >= 0 && maze[leftX][leftY] == '.') {
                queue.add(new Pos(leftX, leftY, pos.c+1));
            }
        }
        return -1;
    }
}
