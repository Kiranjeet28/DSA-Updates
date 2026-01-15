import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] visted = new boolean[grid.length][grid[0].length];
        Queue<int[][]> queue = new java.util.LinkedList<>();
        int count = 0;
        int rottenFruit = 0;
        int freshFruit = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[][]{{i, j}});
                    rottenFruit++;
                    visted[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }
        if (freshFruit == 0)
            return 0;
        if (rottenFruit == 0)
            return -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[][] point = queue.poll();
                int x = point[0][0];
                int y = point[0][1];
                // right
                if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visted[x + 1][y]) {
                    grid[x + 1][y] = 2;
                    visted[x + 1][y] = true;
                    queue.add(new int[][] { { x + 1, y } });
                    freshFruit--;
                }
                // left
                if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visted[x - 1][y]) {
                    grid[x - 1][y] = 2;
                    visted[x - 1][y] = true;
                    queue.add(new int[][] { { x - 1, y } });
                    freshFruit--;
                }
                // down 
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1 && !visted[x][y + 1]) {
                    grid[x][y + 1] = 2;
                    visted[x][y + 1] = true;
                    queue.add(new int[][] { { x, y + 1 } });
                    freshFruit--;
                }
                // up
                if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visted[x][y - 1]) {
                    grid[x][y - 1] = 2;
                    visted[x][y - 1] = true;
                    queue.add(new int[][] { { x, y - 1 } });
                    freshFruit--;
                }

            }
        }
        if(freshFruit>0) return -1;
        return count;

    }
}