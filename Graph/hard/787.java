import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // build graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[] { f[1], f[2] });
        }

        // min-heap: cost first
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        // (node, cost, stops)
        pq.offer(new Tuple(src, 0, 0));

        // best[node][stops] = min cost to reach node using stops
        int[][] best = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            // reached destination
            if (node == dst)
                return cost;

            // stop limit exceeded
            if (stops > k)
                continue;

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int price = nei[1];

                int newCost = cost + price;

                if (newCost < best[next][stops + 1]) {
                    best[next][stops + 1] = newCost;
                    pq.offer(new Tuple(next, newCost, stops + 1));
                }
            }
        }

        return -1;
    }

    class Tuple implements Comparable<Tuple> {
        int node;
        int cost;
        int stops;

        Tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Tuple other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
