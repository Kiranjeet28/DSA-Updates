// User function Template for Java

class Solution {
 
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // To optimize space, we should use a DP array based on the shorter string.
        // If str1 is shorter than str2, we swap them to ensure our dp array is always smaller.
        if (n < m) {
            return lcs(str2, str1);
        }

        // dp array stores the results for the previous row of the 2D DP table.
        // Its size is based on the length of the shorter string (str2).
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; // This will hold the value of dp[i-1][j-1] (the diagonal value)

            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // Store the old dp[j] which is dp[i-1][j]

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, take the diagonal value and add 1.
                    dp[j] = 1 + prev;
                } else {
                    // If they don't match, take the max of the top (dp[j]) or left (dp[j-1]) value.
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp; // The current temp becomes the 'prev' for the next iteration.
            }
        }

        return dp[m]; // The last element of the dp array will hold the LCS length.
    }
}
