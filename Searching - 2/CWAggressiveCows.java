import java.util.Arrays;

public class CWAggressiveCows {
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
        int[] stalls = {0, 3, 4, 7, 10, 9};
        Arrays.sort(stalls);
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}
