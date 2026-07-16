class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bfs(int node, int parent, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { node, parent });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currNode = current[0];
            int currParent = current[1];

            for (int neighbor : adj[currNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[] { neighbor, currNode });
                } else if (neighbor != currParent) {
                    return true;
                }
            }
        }
        return false;
    }
}
