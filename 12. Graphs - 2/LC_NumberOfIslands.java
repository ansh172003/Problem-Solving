public class LC_NumberOfIslands {
    public void dfs(int i, int j, int[][] vis, char[][] isConnected){
        vis[i][j] = 1;
        int n = isConnected.length;
        int m = isConnected[0].length;
        if((i - 1) >= 0 && isConnected[i-1][j] == '1' && vis[i-1][j] == 0) dfs(i-1, j, vis, isConnected);
        if((i  + 1) < n && isConnected[i+1][j] == '1' && vis[i+1][j] == 0) dfs(i+1, j, vis, isConnected);
        if((j - 1) >= 0 && isConnected[i][j-1] == '1' && vis[i][j-1] == 0) dfs(i, j-1, vis, isConnected);
        if((j + 1) < m && isConnected[i][j+1] == '1' && vis[i][j+1] == 0) dfs(i, j+1, vis, isConnected);
    }
    public int numIslands(char[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        int[][] vis = new int[n][m];
        int sol = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && isConnected[i][j] == '1'){
                    dfs(i, j, vis, isConnected);
                    sol++;
                }
            }
        }
        return sol;
    }
}
