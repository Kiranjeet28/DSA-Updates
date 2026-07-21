// https://www.geeksforgeeks.org/problems/geeks-training/1

import java.util.Arrays;

class Solution {

    int[][] dp;
    int row, col;
    int[][] matGlb;

    public int maximumPoints(int mat[][]) {

        matGlb = mat;
        row = mat.length;
        col = mat[0].length;

        dp = new int[row][col];

        for (int[] rowArr : dp) {
            Arrays.fill(rowArr, -1);
        }

        return Math.max(
                checkDP(0, 0),
                Math.max(checkDP(0, 1), checkDP(0, 2))
        );
    }

    public int checkDP(int i, int j) {

        // Base Case
        if (i >= row)
            return 0;

        // Memoization
        if (dp[i][j] != -1)
            return dp[i][j];

        int iIdx = i + 1;

        // No more days left
        if (iIdx >= row)
            return matGlb[i][j];

        // Next two possible activities
        int jIdx1 = (j + 1) % col;
        int jIdx2 = (j + 2) % col;

        // Recursive calls
        dp[iIdx][jIdx1] = checkDP(iIdx, jIdx1);
        dp[iIdx][jIdx2] = checkDP(iIdx, jIdx2);

        // Current activity points + best of next two activities
        dp[i][j] = matGlb[i][j] + Math.max(dp[iIdx][jIdx1], dp[iIdx][jIdx2]);

        return dp[i][j];
    }
}