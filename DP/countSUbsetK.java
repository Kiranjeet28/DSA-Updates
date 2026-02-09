class Solution {
    int[][] memo;
    static final int MOD = 1000000007;

    int rec(int i, int[] arr, int K) {
        if (i == arr.length) {
            return (K == 0) ? 1 : 0;
        }

        if (memo[i][K] != -1)
            return memo[i][K];

        int exclude = rec(i + 1, arr, K) % MOD;
        int include = 0;

        if (arr[i] <= K)
            include = rec(i + 1, arr, K - arr[i]) % MOD;

        return memo[i][K] = (include + exclude) % MOD;
    }

    public int perfectSum(int[] arr, int K) {
        memo = new int[arr.length][K + 1];
        for (int i = 0; i < arr.length; i++)
            Arrays.fill(memo[i], -1);

        return rec(0, arr, K);
    }
}
