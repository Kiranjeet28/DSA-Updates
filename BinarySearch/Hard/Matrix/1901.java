import java.util.*;

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[2];

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int currentElement = mat[row][col];

            int top    = (row - 1 >= 0) ? mat[row - 1][col] : -1;
            int bottom = (row + 1 < m) ? mat[row + 1][col] : -1;
            int left   = (col - 1 >= 0) ? mat[row][col - 1] : -1;
            int right  = (col + 1 < n) ? mat[row][col + 1] : -1;

            if (currentElement > top && currentElement > bottom &&
                currentElement > left && currentElement > right) {
                result[0] = row;
                result[1] = col;
                return result;
            }

            // Move in direction of the largest neighbor
            if (top > currentElement) {
                row--;
            } else if (bottom > currentElement) {
                row++;
            } else if (left > currentElement) {
                col--;
            } else if (right > currentElement) {
                col++;
            } else {
                break; // No bigger neighbor found (shouldn't happen if there's a peak)
            }
        }
        return result; // if not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32},
        };

        System.out.println(Arrays.toString(sol.findPeakGrid(mat)));
    }
}
