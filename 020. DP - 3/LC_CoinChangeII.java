import java.util.Arrays;

public class LC_CoinChangeII {

    public int memoApproach(int amt, int[] coins){
        int n = coins.length;
        int[][] memo = new int[n][amt+1];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return memoApproachHelp(n-1, amt, coins, memo);
    }
    public int memoApproachHelp(int idx, int amt, int[] coins, int[][] memo){
        if(amt == 0) return 1;
        if(amt < 0 || idx < 0) return 0;
        if(memo[idx][amt] == -1) {
            int pick = memoApproachHelp(idx, amt - coins[idx], coins, memo);
            int notPick = memoApproachHelp(idx - 1, amt, coins, memo);
            memo[idx][amt] = pick + notPick;
        }
        return memo[idx][amt];
    }

    public int dpApproach(int amt, int[] coins){
        int[] cache = new int[amt + 1];
        cache[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= amt; ++i) cache[i] += cache[i - coin];
        return cache[amt];
    }

    public int spaceOptimizedApproach(int amt, int[] coins) {
        int n = coins.length;
        int[] cache = new int[amt+1];
        for(int i=1; i<=n; i++) {
            cache[0] = 1;
            for(int j=1; j<=amt; j++) {
                int pick = 0;
                if(j-coins[i-1] >= 0) {
                    pick = cache[j - coins[i - 1]];
                }
                int notPick = cache[j];
                cache[j] = pick+notPick;
            }
        }
        return cache[amt];
    }
    public int change(int amount, int[] coins) {
        return memoApproach(amount, coins);
    }
}
