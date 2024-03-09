public class CWFindFloorSQRT {
    // O(SQRT(N)) Brute force
    public static long findSQRT(long n){
        if(n <= 1) return n;
        for(long i = 2; i < n/2; i++){
            if(i*i > n) return i-1;
        }
        return -1;
    }

    // O(Log(N/2)) Binary Search Approach
    public static long bsFindSQRT(long n){
        if(n <= 1) return n;
        long low = 1;
        long high = n/2; // Min(10^9, n); Similarly for cube root -> Min(10^6, n); for xth root high = Min(10^(18/x), n)
        long mid = 0;
        while ( low <= high){
            mid = (low + high) / 2;
            if(mid * mid  == n) return mid;
            if(mid * mid < n) low = mid + 1;
            else high = mid - 1;
        }
        return mid-1;
    }
    public static void main(String[] args) {
        long n = 100000000;
        long ans = findSQRT(n);
        long ans2 = bsFindSQRT(n);
        System.out.println(ans2);
        System.out.println(ans);

    }
}
