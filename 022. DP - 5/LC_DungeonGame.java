import java.util.Arrays;

public class LC_DungeonGame {
    Integer[][] memo;
    public int memoApproach(int[][] dungeon) {
        memo=new Integer[dungeon.length][dungeon[0].length];
        int ans = memoHelp(dungeon,0,0);
        if(ans==0 && dungeon[0][0]<0) ans=dungeon[0][0];
        if(ans >= 0) return 1;
        return -1 * ans+1;
    }
    public int memoHelp(int[][] dungeon , int i, int j) {
        if(i==dungeon.length-1 && j==dungeon[0].length-1){
            if(dungeon[i][j]>=0) return 0;
            return dungeon[i][j];
        }
        if(i>=dungeon.length || j>=dungeon[0].length){
            return Integer.MIN_VALUE;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int bottom =  memoHelp(dungeon, i+1,j);
        int right = memoHelp(dungeon, i,j+1);
        int val=dungeon[i][j] + Math.max(bottom,right);
        if(val>0) return 0;
        return val;
    }
    public int dpApproach(int[][] dungeon){
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (var e : dp) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        return memoApproach(dungeon);

    }
}
