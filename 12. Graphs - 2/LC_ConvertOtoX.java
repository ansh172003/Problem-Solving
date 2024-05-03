public class LC_ConvertOtoX {
    static int[][] vis;
    public static void dfs(int i, int j, int[][] vis, char[][] board){
        vis[i][j] = 1;
        int n = board.length;
        int m = board[0].length;
        if((i - 1) >= 0 && board[i-1][j] == 'O' && vis[i-1][j] == 0) dfs(i-1, j, vis, board);       //Above
        if((i  + 1) < n && board[i+1][j] == 'O' && vis[i+1][j] == 0) dfs(i+1, j, vis, board);       //Below
        if((j - 1) >= 0 && board[i][j-1] == 'O' && vis[i][j-1] == 0) dfs(i, j-1, vis, board);       //Left
        if((j + 1) < m && board[i][j+1] == 'O' && vis[i][j+1] == 0) dfs(i, j+1, vis, board);        //Right
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        vis = new int[n][m];
        for(int i = 0; i < m; i++){
            if(vis[0][i] == 0 && board[0][i] == 'O') dfs(0, i, vis, board);
            if(vis[n-1][i] == 0 && board[n-1][i] == 'O') dfs(n-1, i, vis, board);
        }

        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O') dfs(i, 0, vis, board);
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O') dfs(i, m-1, vis, board);
        }

        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 1 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][]board1 = {{'X','X','X','X'}, {'X', 'O', 'O', 'X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        char[][]board2 = {{'O', 'O'}, {'O', 'O'}};
        solve(board2);
    }

}
