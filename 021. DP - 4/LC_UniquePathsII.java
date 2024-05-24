public class LC_UniquePathsII {
    public int tabulationApproach(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] tab =new int[n][m];
        tab[0][0]=1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(obstacleGrid[i][j] == 1) {
                    tab[i][j] = 0;
                }
                else{
                    if(i>0) tab[i][j] += tab[i-1][j];
                    if(j>0) tab[i][j] += tab[i][j-1];
                }
            }
        }
        return tab[n-1][m-1];
    }
}
