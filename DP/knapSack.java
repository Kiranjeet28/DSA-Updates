class Solution {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        if (wt == null || val == null || n == 0 || W == 0) {
            return 0;
        }


        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }
}
