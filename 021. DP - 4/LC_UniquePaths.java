import java.util.Arrays;

public class LC_UniquePaths {
    int[][] memo;
    public int memoizationApproach(int m, int n, int i, int j){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(memo[i][j] == 1) return memo[i][j];
        return memo[i][j] = memoizationApproach(m, n, i+1, j) + memoizationApproach(m, n, i, j+1);
    }
    public int tabulationApproach(int m, int n){
        int[][] tab = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(tab[i], 1);
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                tab[i][j] = tab[i-1][j] + tab[i][j-1];
        return tab[m-1][n-1];
    }

}
