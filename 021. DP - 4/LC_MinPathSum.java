public class LC_MinPathSum {
    int[][] memo;
    public int memoizationApproach(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[m][n];
        else if (m < 0 || n < 0) return Integer.MAX_VALUE;
        else if (memo[m][n] != 0) return memo[m][n];
        int up = memoizationApproach(grid, m - 1, n);
        int left = memoizationApproach(grid, m, n - 1);
        return memo[m][n] = grid[m][n] + Math.min(up, left);
    }
    public int dpApproach(int[][] cost){
        int m = cost.length;
        int n = cost[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = cost[0][0];

        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + cost[i][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + cost[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
