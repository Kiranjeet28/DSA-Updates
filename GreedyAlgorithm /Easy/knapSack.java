import java.util.PriorityQueue;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        for (int i = 0; i < val.length; i++) {
            double freq = (double) val[i] / wt[i];
            maxHeap.add(new double[] { i, freq });
        }
        double result = 0;
        while (cap > 0 && !maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();
            int index = (int) curr[0];
            double ratio = curr[1];
            if (wt[index] <= cap) {
                cap -= wt[index];
                result += val[index];
            } else {
                result += ratio * cap;
                cap = 0;
            }
        }
        return result;
    }
}
