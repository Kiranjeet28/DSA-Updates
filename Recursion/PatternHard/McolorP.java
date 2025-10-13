import java.util.*;

class Solution {
    // Helper function to check if it's safe to color node with a given color
    private boolean isSafe(int node, int[][] graph, int[] color, int n, int col) {
        for (int k = 0; k < n; k++) {
            if (graph[node][k] == 1 && color[k] == col) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to try coloring the graph
    private boolean solve(int node, int[][] graph, int m, int n, int[] color) {
        if (node == n) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, n, c)) {
                color[node] = c;
                if (solve(node + 1, graph, m, n, color)) {
                    return true;
                }
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    public boolean graphColoring(int[][] graph, int m, int n) {
        int[] color = new int[n];
        return solve(0, graph, m, n, color);
    }

    public static void main(String[] args) {
        int N = 4, M = 3, E = 5;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2} };
        int[][] graph = new int[N][N];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1; // undirected graph
        }
        Solution sol = new Solution();
        boolean result = sol.graphColoring(graph, M, N);
        System.out.println(result ? "1" : "0");
    }
}
