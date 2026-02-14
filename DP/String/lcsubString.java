class Solution {
    public int longCommSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // dp array for space optimization. dp[j] will store the length of the
        // common substring ending at str1[i-1] and str2[j-1].
        int[] dp = new int[m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            // Iterate backwards to ensure that when we calculate dp[j],
            // dp[j-1] holds the value from the previous row (i-1),
            // which corresponds to the required diagonal dp[i-1][j-1].
            for (int j = m; j >= 1; j--) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, we extend the common substring length
                    // from the diagonal element.
                    dp[j] = 1 + dp[j - 1];
                } else {
                    // If they don't match, the common substring is broken, so reset to 0.
                    dp[j] = 0;
                }

                // Keep track of the maximum length found so far.
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
        }

        return max;
    }
}