import java.util.Arrays;
public class LC_CoinChangeI {
    public int bottomUpApproach(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for (int target = 1; target <= amount; target++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (target - coin >= 0) {
                    int ans = cache[target - coin];
                    if (ans != Integer.MAX_VALUE)
                        minCoins = Math.min(minCoins, 1 + ans);
                }
            }
            cache[target] = minCoins;
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
    public int recursiveApproach(int[] coins, int amount) {
        if (amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = recursiveApproach(coins, amount - coin);
            if (ans != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, 1 + ans);
        }
        return minCoins;
    }
    public int topDownApproach(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (cache[amount] == -1) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                int ans = topDownApproach(coins, amount - coin, cache);
                if (ans != Integer.MAX_VALUE)
                    minCoins = Math.min(minCoins, 1 + ans);
            }
            cache[amount] = minCoins;
        }
        return cache[amount];
    }


    public int coinChange(int[] coins, int amount) {
        return bottomUpApproach(coins, amount);
    }
}
