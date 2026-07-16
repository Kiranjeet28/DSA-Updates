class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if(pa != pb) {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // 1️⃣ Union adjacent lands
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            dsu.union(r * n + c, nr * n + nc);
                        }
                    }
                }
            }
        }
        
        // 2️⃣ Find max island size without conversion
        int maxSize = 0;
        for (int i = 0; i < n * n; i++) {
            if (dsu.find(i) == i) {
                maxSize = Math.max(maxSize, dsu.size[i]);
            }
        }
        
        // 3️⃣ Try converting each water cell to land
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            uniqueIslands.add(dsu.find(nr * n + nc));
                        }
                    }
                    int newSize = 1; // for the converted cell
                    for (int root : uniqueIslands) {
                        newSize += dsu.size[root];
                    }
                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }
        
        return maxSize;
    }
}