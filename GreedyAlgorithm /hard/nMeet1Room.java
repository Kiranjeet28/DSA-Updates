import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

// class Solution {
//     public boolean isValueInRange(Map<Integer, Integer> map, int GetVal) {
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             int key = entry.getKey();
//             int value = entry.getValue();

//             int low = Math.min(key, value);
//             int high = Math.max(key, value);

//             if (GetVal >= low && GetVal <= high) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public int maxMeetings(int[] start, int[] end) {
//         int result = 0;

//         // Sort meetings by end time (greedy strategy)
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//         for (int i = 0; i < start.length; i++) {
//             pq.add(new int[] { start[i], end[i] });
//         }

//         Map<Integer, Integer> hmap = new HashMap<>();

//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int s = curr[0];
//             int e = curr[1];

//             // check if current meeting start time overlaps with existing ones
//             if (!isValueInRange(hmap, s)) {
//                 hmap.put(s, e);
//                 result++;
//             }
//         }

//         return result;
//     }

//     // Example run
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] start = { 1, 3, 0, 5, 8, 5 };
//         int[] end = { 2, 4, 6, 7, 9, 9 };
//         System.out.println(sol.maxMeetings(start, end)); // Output: 4
//     }
// }
// optimize
import java.util.*;

class Solution {

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];  // start time
            meetings[i][1] = end[i];    // end time
        }

        // Sort meetings by end time (greedy strategy)
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = -1;  // end time of the last selected meeting

        for (int[] m : meetings) {
            int s = m[0];
            int e = m[1];

            // Select if current start >= last meeting’s end
            if (s > lastEnd) {
                count++;
                lastEnd = e; // update end time
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(sol.maxMeetings(start, end)); // Output: 4
    }
}
