class Solution {
    public int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.add(stick);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }

        return totalCost;
    }
}