//https://www.geeksforgeeks.org/problems/minimum-sum-in-a-falling-path/1
import java.util.*;

class Solution {
    int[][] dp;
    int row, col;

    public int minFallingPathSum(int[][] mat) {

        row = mat.length;
        col = mat[0].length;

        dp = new int[row][col];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < col; i++) {
            ans = Math.min(ans, dpCheck(mat, 0, i));
        }

        return ans;
    }

    public int dpCheck(int[][] mat, int r, int c) {

        if (r >= row || c < 0 || c >= col)
            return Integer.MAX_VALUE;

        if (dp[r][c] != -1)
            return dp[r][c];

        if (r == row - 1)
            return mat[r][c];

        int down = dpCheck(mat, r + 1, c);
        int left = dpCheck(mat, r + 1, c - 1);
        int right = dpCheck(mat, r + 1, c + 1);

        dp[r][c] = mat[r][c] + Math.min(down, Math.min(left, right));

        return dp[r][c];
    }
}