import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            adj.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Add courses with 0 indegree
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        // Kahn's Algorithm
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[count] = node;
            count++;

            for (int next : adj.getOrDefault(node, new ArrayList<>())) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 10 }, { 3, 18 }, { 5, 5 }, { 6, 11 },
                { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 }
        };

        int numCourses = 19; // must be >= max course id + 1

        Solution s = new Solution();
        System.out.println(s.canFinish(numCourses, arr)); // false (cycle at 5->5)
    }
}
