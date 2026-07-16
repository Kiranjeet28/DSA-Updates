import java.util.*;

class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int originalColor = grid[sr][sc];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (originalColor == color)
            return grid;
        Queue<int[][]> queue = new LinkedList<>();
       
        queue.add(new int[][] { { sr, sc } });
        visited[sr][sc] = true;
        grid[sr][sc] = color;
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[][] point = queue.poll();
                int x = point[0][0];
                int y = point[0][1];
                // RIGHT 
                if (x + 1 < grid.length  && !visited[x + 1][y] && grid[x + 1][y] == originalColor) {
                    visited[x + 1][y] = true;
                    grid[x + 1][y] = color;
                    queue.add(new int[][] { { x + 1, y } });
                }
                if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] == originalColor) {
                    visited[x - 1][y] = true;
                    grid[x - 1][y] = color;
                    queue.add(new int[][] { { x - 1, y } });
                }
                //Down
                if (y + 1 < grid[0].length && !visited[x][y + 1] && grid[x][y + 1] == originalColor) {
                    visited[x][y + 1] = true;
                    grid[x][y + 1] = color;
                    queue.add(new int[][] { { x, y + 1 } });
                }
                //up
                if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] == originalColor) {
                    visited[x][y - 1] = true;
                    grid[x][y - 1] = color;
                    queue.add(new int[][] { { x, y - 1 } });
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};
        grid = s.floodFill(grid, 1, 1, 2);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(grid[i][j]);
            }
        }
    }
}

// Finite approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        paint(image, image[sr][sc], sr, sc, color);
        return image;
    }

    private void paint(int[][] image, int originColor, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originColor
                || image[sr][sc] == color)
            return;
        image[sr][sc] = color;

        paint(image, originColor, sr - 1, sc, color);
        paint(image, originColor, sr + 1, sc, color);
        paint(image, originColor, sr, sc - 1, color);
        paint(image, originColor, sr, sc + 1, color);
        return;
    }
}