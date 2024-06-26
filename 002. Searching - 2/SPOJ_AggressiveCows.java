import java.util.*;
import java.lang.*;

class SPOJ_AggressiveCows {
    public static boolean canWePlace(int[] stalls, int cows, int dist){
        int placedCows = 1;
        int lastCow = stalls[0];
        int n = stalls.length;

        for(int i = 1; i < n; i++){
            if(stalls[i] - lastCow >= dist){
                placedCows++;
                lastCow = stalls[i];
            }
        }

        return (placedCows >= cows);
    }
    public static int aggressiveCows(int[] stalls, int cowCount){
        int low = 0;
        int stallCount = stalls.length;
        int high = stalls[stallCount - 1] - stalls[0];

        while(low <= high){
            int mid = (low + high) / 2;
            if(canWePlace(stalls, cowCount, mid)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] stalls = new int[n];
            for(int i = 0; i<n; i++){
                stalls[i] = sc.nextInt();
            }
            Arrays.sort(stalls);
            int ans = aggressiveCows(stalls, c);
            System.out.println(ans);
        }
    }
}
