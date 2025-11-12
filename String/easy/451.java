import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (char c = 0; c < 256; c++) {
            if (freq[c] > 0) pq.offer(new int[]{c, freq[c]});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int i = 0; i < curr[1]; i++) sb.append((char) curr[0]);
        }
        return sb.toString();
    }
}