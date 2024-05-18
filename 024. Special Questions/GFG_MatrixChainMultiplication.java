import java.util.Arrays;

public class GFG_MatrixChainMultiplication {
    // Recursion Approach - TlE
    static int recursionHelper(int st, int end, int[] arr){
        if(st == end) return 0;

        int minVal = Integer.MAX_VALUE;
        for(int partition = st; partition < end; partition++){
            int steps = arr[st - 1] * arr[partition] * arr[end] + recursionHelper(st, partition, arr) + recursionHelper(partition + 1, end, arr);
            if(steps < minVal) minVal = steps;
        }
        return minVal;
    }
    static int matrixMultiplicationRecursion(int N, int[] arr) {
        return recursionHelper(1, N-1, arr);
    }




    // Recursion Memoization
    static int memoHelper(int st, int end, int[] arr, int[][] memo){
        if(st == end) return 0;
        if(memo[st][end] == -1){
            int minVal = Integer.MAX_VALUE;
            for(int partition = st; partition < end; partition++){
                int steps = arr[st - 1] * arr[partition] * arr[end] + memoHelper(st, partition, arr, memo) + memoHelper(partition + 1, end, arr, memo);
                if(steps < minVal) minVal = steps;
            }
            memo[st][end] = minVal;
        }
        return memo[st][end];
    }
    static int matrixMultiplicationMemoization(int N, int[] arr) {
        int[][] memo = new int[N][N];
        for(int[] i : memo) Arrays.fill(i, -1);
        return memoHelper(1, N-1, arr, memo);
    }


    // Bottom Up Approach
    static int matrixMultiplicationBottomUp(int n, int[] arr){
        int[][] dp = new int[n][n];
        for(int i = 0; i <n; i++) dp[i][i] = 0;

        for(int i = n-1; i >= 1; i--){
            for(int j = i +1; j < n; j++){
                int minVal = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int step = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    if(step < minVal) step = minVal;
                }
                dp[i][j] = minVal;
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        System.out.println(matrixMultiplicationRecursion(arr.length, arr));
        System.out.println(matrixMultiplicationMemoization(arr.length, arr));
        System.out.println(matrixMultiplicationBottomUp(arr.length, arr));
    }
}
