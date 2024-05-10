public class LC_PerfectSquares {
    public int recursiveApproach(int n){
        if (n < 4) return n;
        int res = n;
        for (int i = 1; i * i <= n; i++) {
            int sq = i * i;
            res = Math.min(res, numSquares(n - sq) + 1);
        }
        return res;
    }

    public int memoApproach(int n){
        int[] memo = new int[n+1];
        for(int i = 0; i <=n ; i++) memo[i] = -1;
        int sol = memoApproachHelp(n, memo);
        return sol;
    }
    public int memoApproachHelp(int n, int[] memo){
        if(n == 0) return 0;
        if(memo[n] == -1){
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i * i <= n; i++){
                int sq = i*i;
                int t = memoApproachHelp( n- sq, memo);
                ans = Math.min(ans, t);
            }
            memo[n] = ans;
        }
        return memo[n];
    }

    public int bottomUpApproach(int n){
        int[] cache=new int[n+1];
        for(int i = 0; i<=n; i++) cache[i] = Integer.MAX_VALUE;
        cache[0] = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j*j <= i; j++) {
                int sq = j * j;
                cache[i] = Math.min(cache[i], cache[i - sq] + 1);
            }
        }
        return cache[n];
    }

    public int numSquares(int n) {
        return recursiveApproach(n);
    }
}
