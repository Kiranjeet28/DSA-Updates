class ropCutting {
    public int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);    
            }
            dp[i] = maxVal;
        }
        return dp[n];
    }

}