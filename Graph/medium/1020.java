class Solution {
    public int numEnclaves(int[][] grid) {
        int count =0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // for boundry row 
        for (int i = 0; i < grid.length; i++) {
            if (grid[0][i] == 1 && visited[0][i] == false) {
                dfs(0, i, visited, grid);
            }
            if (grid[grid.length - 1][i] == 1 && visited[grid.length - 1][i] == false) {
                dfs(grid.length - 1, i, visited, grid);
            }
        }
        
        //for boundry col 
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[i][0] == 1 && visited[i][0] == false) {
                dfs(i, 0, visited, grid);
            }
            if (grid[i][grid[0].length - 1] == 1 && visited[i][grid[0].length - 1] == false) {
                dfs(i, grid[0].length - 1, visited, grid);
            }
        }
        
        for(int i =0 ; i < grid.length;i++){
            for(int j =0 ; j< grid[0].length;j++){
                if(grid[i][j] == 1 && visited[i][j] == false ){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, boolean[][] visited, int[][] grid) {
        System.out.println("No of count of me ");
        if (row < 0 || row >= grid.length || col >= grid[0].length || col < 0 || grid[row][col] == 0
                || visited[row][col] == true)
            return;

        visited[row][col] = true;

        // other side move 
        dfs(row + 1, col, visited, grid);
        dfs(row - 1, col, visited, grid);
        dfs(row, col + 1, visited, grid);
        dfs(row, col - 1, visited, grid);

    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        Solution s = new Solution();
        int count = s.numEnclaves(grid);
        System.out.println(count);
    }
}