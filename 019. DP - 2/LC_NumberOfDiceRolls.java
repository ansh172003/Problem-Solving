import java.util.Arrays;

public class LC_NumberOfDiceRolls {
    public int recursiveApproach(int n, int k, int target){
        if(n < 0) return 0;
        if(n == 0 && target == 0) return 1;
        if(n != 0 && target == 0) return 0;
        if(n == 0) return 0;

        int ans = 0;
        for(int i = 1; i <= k; i++) ans += recursiveApproach(n-1, k, target-i);
        return (ans % 1000000007);
    }
    public int bottomUpApproach(int n, int k, int target){
        int m = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int index = 1; index <= n; index++) {
            for (int t = 1; t <= target; t++) {
                int ans = 0;
                for (int i = 1; i <= k; i++) {
                    if (t - i >= 0)
                        ans = (ans % m) + (dp[index - 1][t - i] % m);
                }
                dp[index][t] = (ans % m);
            }
        }
        return dp[n][target];
    }
    public int spaceOptimizedApproach(int n, int k, int target) {
        int m = 1000000007;
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];
        for(int i =0; i<= target; i++){
            prev[i] = 0;
            curr[i] = 0;
        }
        prev[0] = 1;
        for (int index = 1; index <= n; index++) {
            for (int t = 1; t <= target; t++) {
                int ans = 0;
                for (int i = 1; i <= k; i++) {
                    if (t - i >= 0)
                        ans = (ans % m) + (prev[t - i] % m);
                }
                curr[t] = (ans % m);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[target];
    }

    public int numRollsToTarget(int n, int k, int target) {
        return bottomUpApproach(n,k,target);

    }
}
