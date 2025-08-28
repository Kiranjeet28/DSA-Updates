class Solution {
    // Binary search in a single row
    public int lowerBound(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // index = count of elements < target
    }

    // Count of elements in the whole matrix < target
    public int countLessThan(int[][] matrix, int target) {
        int count = 0;
        for (int[] row : matrix) {
            count += lowerBound(row, target);
        }
        return count;
    }

    public int findMedian(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int minInt = matrix[0][0];
        int maxInt = matrix[m - 1][n - 1];
        int desiredCount = (m * n) / 2; // correct formula

        // Binary search on the value range
        while (minInt < maxInt) {
            int mid = minInt + (maxInt - minInt) / 2;
            int count = countLessThan(matrix, mid + 1); // +1 to handle equality correctly

            if (count <= desiredCount) {
                minInt = mid + 1;
            } else {
                maxInt = mid;
            }
        }
        return minInt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        System.out.println("Median: " + sol.findMedian(matrix)); // Output: 5
    }
}
