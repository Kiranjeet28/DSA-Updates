import java.util.*;
class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            if (!rankMap.containsKey(current)) {
                rankMap.put(current, rank);
                rank++;
            }
        }
        for (int i = 0; i < N; i++) {
            arr[i] = rankMap.get(arr[i]);
        }   
     
        return arr;
    }
}
