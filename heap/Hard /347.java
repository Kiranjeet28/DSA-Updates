class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]));
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                result[i] = maxHeap.poll()[0];
            }
        }
        return result;
    }
}