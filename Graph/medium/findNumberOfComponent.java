import java.util.List;

public class findNumberOfComponent{
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int count = 0;
        boolean[] visited = new boolean[V];
        List<List<Integer>> adj = new java.util.ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}