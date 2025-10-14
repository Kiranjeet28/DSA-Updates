class Solution {
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '0'; k <= '9'; k++) {
                        //check vaild for current position
                        if (check(board, i, j, k)) {
                            //place number 
                            board[i][j] = k;
                            //for others 
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int l, int j,int k ) {
        //check k is a vaild no. for board[l][j]
        for (int i = 0; i < 10; i++) {
            if (board[l][i] == k || board[i][j] == k)
                return false;
            // check 3x3 sub-box
            int subRow = 3 * (l / 3) + i / 3;
            int subCol = 3 * (j / 3) + i % 3;
            if (board[subRow][subCol] == k) {
                return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}