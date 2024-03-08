import java.util.*;

class Main {
    public static void minHeight(int[] heights, int[] tests){
        Arrays.sort(heights);
        int n = heights.length;
        for(int x : tests){
            int low = 0;
            int high = n - 1;
            int count = 0;
            while(low <= high){
                int mid = (high - low) / 2 + low;
                if(heights[mid] >= x) {
                    count += (high - mid) + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] heights = new int[n];
        int[] tests = new int[t];

        for(int i = 0; i < n; i++) heights[i] = sc.nextInt();
        for(int i = 0; i < t; i++) tests[i] = sc.nextInt();
        sc.close();
        minHeight(heights, tests);
    }
}
