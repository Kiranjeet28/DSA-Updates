import java.util.*;
class Solution {
    public void rec(List<String> FL,int[][] grid, int currN, int currM, String curr,boolean visted[][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (curr.length() > m* n) {
            return;
        }
        if (currN == n - 1 && currM == m - 1) {
            FL.add(curr);
            visted[currN][currM] = false;
            return;
        }
        if (currN == -1 || currM == -1 || currN >= n || currM >= m) {
            return;
        }
        
        System.out.println(visted[currN][currM]);
        if (grid[currN][currM] == 0 || visted[currN][currM] == true) {
            return;
        }
        visted[currN][currM] = true;
        System.out.println("a");

        //UP 
        rec(FL, grid, currN - 1, currM , curr + "U", visted);
        
        // down 
        rec(FL, grid, currN + 1, currM, curr + "D", visted);

        // left 
        rec(FL, grid, currN, currM - 1, curr + "L", visted);

        // right
        rec(FL, grid, currN, currM+1, curr + "R", visted);
        visted[currN][currM] = false;

    }

    public List<String> findPath(int[][] grid) {
        List<String> FL = new ArrayList<>();

        boolean[][] visted = new boolean[grid.length][grid[0].length];
        rec(FL, grid, 0, 0, "", visted);
        System.out.println(FL);
        return FL;
    }
    public static void main(String[] args) {
        
        int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        Solution s = new Solution();
        s.findPath(grid); 
    }
}