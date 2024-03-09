public class CWFindFloorSQRT {
    // O(SQRT(N)) Brute force
    public static int findSQRT(int n){
        if(n <= 1) return n;
        for(int i = 2; i <= n/2; i++){
            if(i*i >= n) return i-1;
        }
        return -1;
    }

    // O(Log(N/2)) Binary Search Approach
    public static int bsFindSQRT(int n){
        long low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                low = (int)(mid + 1);
            } else {
                high = (int)(mid - 1);
            }
        }
        return (int)(high);
    }
    public static void main(String[] args) {
        int n = 8;
        int ans2 = bsFindSQRT(n);
        System.out.println(ans2);

    }
}
