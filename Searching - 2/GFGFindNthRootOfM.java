public class GFGFindNthRootOfM {
    public static int findPow(int x, int p, int val){
        long ans = 1;
        for(int i = 0; i<p; i++){
            ans *= x;
            if(ans > val) return 2;
        }
        if(ans == val) return 0;
        else return 1;
    }

    public int NthRoot(int r, int x){
        int low = 1;
        int high = x;
        while(low <= high){
            int mid = (low + high) / 2;
            int p = findPow(mid, r, x);
            if(p == 0) return mid;
            else if(p == 1) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
