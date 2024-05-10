import java.util.*;

public class LC_ClimbingStairs {
    public int recursionApproach(int n){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        return recursionApproach(n-1) + recursionApproach(n-2);
    }
    public int memoApproach(int n){
        Map<Integer, Integer> m = new HashMap<>();
        return memoApproachHelp(n, m);
    }
    public int memoApproachHelp(int n, Map<Integer, Integer>m){
        if(n == 0 || n == 1) return 1;
        if(!m.containsKey(n)){
            int ways = memoApproachHelp(n-1, m) + memoApproachHelp(n-2, m);
            m.put(n, ways);
        }
        return m.get(n);
    }

    public int bottomUP(int n){
        int[] cache = new int[n+1];
        if(n <= 2) return n;
        for(int i = 0; i < 3; i++) cache[i] = i;
        for(int i = 3; i<=n; i++) cache[i] = cache[i-1] + cache[i-2];
        return cache[n];
    }

    public int spaceOptimized(int n){
        if(n<=2) return n;
        int stair1 = 1;
        int stair2 = 2;
        int stair3 = 0;
        for(int i = 3; i<=n; i++){
            stair3 = stair1 + stair2;
            stair1 = stair2;
            stair2 = stair3;
        }
        return stair3;

    }
    public int climbStairs(int n) {
        return bottomUP(n);
    }
}
