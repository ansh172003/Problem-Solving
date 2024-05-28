public class LC_ShortestCommonSubsequence {
    public String LCS(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int j = 0; j <= m; j++) dp[0][j] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1 == c2) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j]>dp[i][j - 1]) i--;
            else j--;
        }
        return sb.reverse().toString();
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        String str = LCS(s1, s2);
        StringBuilder ans = new StringBuilder();
        int p1 = 0, p2 = 0;
        for(char c:str.toCharArray()){
            while(p1<s1.length()&&s1.charAt(p1)!=c){
                ans.append(s1.charAt(p1++));
            }
            while(p2<s2.length()&&s2.charAt(p2)!=c){
                ans.append(s2.charAt(p2++));
            }
            ans.append(c);
            p1++;
            p2++;
        }

        if(p1 < s1.length()) ans.append(s1.substring(p1));
        if(p2 < s2.length()) ans.append(s2.substring(p2));
        return ans.toString();
    }
}
