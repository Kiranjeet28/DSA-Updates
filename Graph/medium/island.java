import java.util.*;

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<String> shapes = new HashSet<>();

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> cells = new ArrayList<>();
                    bfs(grid, visited, i, j, cells, dir);

                    // 🔑 SHIFT OPERATION
                    shapes.add(normalize(cells));
                }
            }
        }
        return shapes.size();
    }

    void bfs(int[][] grid, boolean[][] visited, int sr, int sc,
            List<int[]> cells, int[][] dir) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            cells.add(new int[] { r, c });

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                        && grid[nr][nc] == 1 && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
    }

    // 🔑 SHIFT (TRANSLATION)
    String normalize(List<int[]> cells) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for (int[] c : cells) {
            minR = Math.min(minR, c[0]);
            minC = Math.min(minC, c[1]);
        }

        List<String> shifted = new ArrayList<>();
        for (int[] c : cells) {
            shifted.add((c[0] - minR) + "," + (c[1] - minC));
        }

        Collections.sort(shifted);
        return String.join("|", shifted);
    }
}
