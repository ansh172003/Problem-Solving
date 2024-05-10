public class GFG_AdjacentNotAllowed {
    // DP Approach
    static int dpApproach(int N, int[][] mat){
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = Math.max(mat[0][0], mat[1][0]);
        dp[2] = Math.max(dp[1], Math.max(mat[0][1], mat[1][1]));

        for(int i=3; i<=N; i++) {
            int t1 = Math.max(mat[0][i - 1], mat[1][i - 1]);
            dp[i] = Math.max(dp[i - 2] + t1, dp[i - 1]);
        }
        return dp[N];
    }
    static int spaceOptimized(int n, int[][] mat){
        int p1 = 0;
        int p2 = Math.max(mat[0][0],mat[1][0]);
        int p3 = 0;
        for(int i = 2; i <= n; i++){
            int t = Math.max(mat[0][i-1], mat[1][i-1]);
            p3 = Math.max(p2, t + p1);
            p1 = p2;
            p2 = p3;
        }
        return p3;
    }
    static int maxSum(int N, int[][] mat){
        return dpApproach(N, mat);
    }
}
