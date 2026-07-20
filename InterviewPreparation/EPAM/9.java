/*16. Spiral Traversal of a Matrix
Print elements of a 2D matrix in spiral order, starting from the top-left corner.

Input: Matrix (e.g., [[1, 2, 3], [4, 5, 6], [7, 8, 9]])
Output: Array (e.g., [1, 2, 3, 6, 9, 8, 7, 4, 5])
 */
class Solution{
    void printSpiral (int[][] matrix, int row, int col){
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            for(int i = top; i <= bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}