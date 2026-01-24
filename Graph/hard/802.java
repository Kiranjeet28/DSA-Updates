class Solution {
    public List<Integer> bfs(ArrayList<Integer>[] graph, Queue<Integer> q, int[] inDeg) {
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr); // inDeg = 0
            for (int ngbr : graph[curr]) {
                inDeg[ngbr]--; // decrement inDegree for ngbr
                if (inDeg[ngbr] == 0)
                    q.offer(ngbr); // if inDeg = 0 => process it next
            }
        }
        Collections.sort(res); // as question demands sorted order
        return res;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] inDeg = new int[V];
        ArrayList<Integer>[] adj = new ArrayList[V]; // reversed graph
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            // reverse all the edges of the graph
            for (int u : graph[i]) {
                adj[u].add(i);
                inDeg[i]++; // also store inDegree for vertices
            }
        }
        Queue<Integer> q = new LinkedList<>(); // for bfs
        for (int i = 0; i < V; i++) {
            // insert all the nodes to queue whose inDegree = 0
            if (inDeg[i] == 0)
                q.offer(i);
        }
        return bfs(adj, q, inDeg);
    }
}