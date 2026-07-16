class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high = m*n-1;
        while(high>=low){
            int mid = low + (high-low)/2;
            int col = mid%n;
            int row = mid/n;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
     public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
            { 1},
        };

        System.out.println(sol.searchMatrix(mat,4)); 
    }
}