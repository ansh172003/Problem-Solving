public class LC_LongestCommonSubsequence {
    public int dpApproach(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=m; j++) dp[0][j] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1 == c2) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return  dpApproach(text1, text2);
    }
}
