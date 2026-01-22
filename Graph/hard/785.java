import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {

        int NoOfNodes = graph.length;
        boolean visted[] = new boolean[graph.length];
        int coloredGraph[] = new int[graph.length];
        Arrays.fill(coloredGraph, -1); // ✅ added (uncolored)

        Queue<Pair> queue = new LinkedList<>();

        // ✅ handle disconnected graph
        for (int start = 0; start < NoOfNodes; start++) {
            if (visted[start])
                continue;

            queue.offer(new Pair(start, 0));
            coloredGraph[start] = 0;

            while (!queue.isEmpty()) {
                Pair curr = queue.poll();
                visted[curr.nodeNo] = true;

                for (int i = 0; i < graph[curr.nodeNo].length; i++) {

                    // ✅ correct indexing
                    int neighbor = graph[curr.nodeNo][i];

                    if (coloredGraph[neighbor] == -1) {
                        coloredGraph[neighbor] = 1 - curr.color; // ✅ correct color logic
                        queue.offer(new Pair(neighbor, coloredGraph[neighbor]));
                    } else if (coloredGraph[neighbor] == curr.color) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    class Pair {
        int color;
        int nodeNo;

        Pair(int n, int c) {
            this.nodeNo = n; // ✅ fixed constructor
            this.color = c;
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        Solution s = new Solution();
        System.out.println(s.isBipartite(graph));
    }
}
