class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }

        return count;
    }
    public void dfs(int i, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, visited, isConnected);
            }
        }
    }
}