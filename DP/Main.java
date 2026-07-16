import java.util.*;

class Solution {
    // Function to count partitions with given difference
    public int countPartitions(int[] arr, int d) {
        // Calculate total sum of array
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        // Check if solution is possible
        if ((totalSum + d) % 2 != 0 || d > totalSum)
            return 0;

        // Calculate target sum
        int K = (totalSum + d) / 2;

        // Create dp array of size K+1
        int[] dp = new int[K + 1];
        dp[0] = 1;

        // If first element <= K, mark it
        if (arr[0] <= K)
            dp[arr[0]] += 1;

        // Process remaining elements
        for (int i = 1; i < arr.length; i++) {
            int[] curr = new int[K + 1];
            curr[0] = 1;

            for (int t = 0; t <= K; t++) {
                int notTake = dp[t];
                int take = 0;
                if (arr[i] <= t) {
                    take = dp[t - arr[i]];
                }
                curr[t] = take + notTake;
            }
            dp = curr;
        }
        return dp[K];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 1, 2, 3, 4 };
        int d = 1;
        System.out.println(sol.countPartitions(arr, d));
    }
}
