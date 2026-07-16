class Solution {
    static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; 
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; 
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[m];
    }
}