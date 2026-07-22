// https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1

class Solution {
    int[][] gridDP; 
    // boolean[][] dp;
    int row,col;
    int result;
    // public int uniquePaths(int[][] grid) {
    //     row = grid.length;
    //     col = grid[0].length;
    //     gridDP = grid;
    //     dp = new boolean[row][col];
    //     result = 0; 
    //     checkPath(0,0);
    //     return result;
    // }
    // public void checkPath(int r, int c){
    //     if(r>row-1 || c>col-1) return;
    //     if(gridDP[r][c] == 1 || dp[r][c] == true) return;
    //     if(r == row-1 && c == col-1){ 
    //         result+=1; 
    //         return;
    //     }
    //     dp[r][c] = true;
    //     checkPath(r+1,c);
    //     checkPath(r,c+1);
    //     dp[r][c] = false;
    // }
    int dp[][];
    public int uniquePaths(int[][] grid){
         row = grid.length;
        col = grid[0].length;
        gridDP = grid;
        dp = new int[row][col];
        result = 0; 
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        return checkPath(0,0);
    }
    public void CheckPath(int r , int c){
        if(r>row-1 || c>col-1) return 0;
        if(gridDP[r][c] == 1) return 0;
        if (r == row - 1 && c == col - 1)
            return 1;

        if (dp[r][c] != -1)
            return dp[r][c];

         dp[r][c] = checkPath(r + 1, c) + checkPath(r, c + 1);

         return dp[r][c];
    }
};