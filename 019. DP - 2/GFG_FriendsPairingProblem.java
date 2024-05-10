import java.util.Arrays;

public class GFG_FriendsPairingProblem {
    public long recursiveApproach(int n) {
        if(n == 0) return 1;
        long single = recursiveApproach(n-1);
        long pair = 0;
        if(n - 2 >= 0) pair = recursiveApproach(n-2) * (n - 1);
        return (single + pair) % 1000000007;
    }
    public long memoApproach(int n) {
        long[] memo = new long[n+1];
        Arrays.fill(memo,-1);
        return memoApproachHelp(n,memo);
    }
    public static long memoApproachHelp(int n,long[] memo){
        if(n == 0) return 1;
        if(memo[n] == -1) {
            long single = memoApproachHelp(n - 1, memo);
            long pair = 0;
            if (n - 2 >= 0) {
                pair = memoApproachHelp(n - 2, memo) * (n - 1);
            }
            memo[n] = (single + pair) % 1000000007;
        }
        return memo[n];
    }
    public long dpApproach(int n) {
        long[] cache = new long[n+1];
        Arrays.fill(cache,-1);
        cache[0] = 1;
        for(int i=1;i<=n;i++){
            long single = cache[i-1];
            long pair = 0;
            if(i - 2 >= 0){
                pair = cache[i-2] * (i - 1);
            }
            cache[i] = (single + pair) % 1000000007;
        }
        return cache[n];
    }
    public long countFriendsPairings(int n) {
        return memoApproach(n);
    }
}
