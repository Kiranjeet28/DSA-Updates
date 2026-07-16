class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        System.out.println(sol.searchMatrix(mat, 5));  // true
        System.out.println(sol.searchMatrix(mat, 20)); // false
    }
}
