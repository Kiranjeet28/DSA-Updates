class Solution {
    private int firstOneIndex(int[] row) {
        int low = 0, high = row.length - 1;
        int firstOne = row.length; 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                firstOne = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return firstOne;
    }

    public int rowWithMax1s(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int maxRowIndex = -1;
        int maxOnes = 0;

        for (int i = 0; i < rows; i++) {
            int firstOne = firstOneIndex(mat[i]);
            int countOnes = cols - firstOne;

            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                maxRowIndex = i;
            }
        }

        return (maxOnes == 0) ? -1 : maxRowIndex;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
        };

        System.out.println(sol.rowWithMax1s(mat)); 
    }
}
