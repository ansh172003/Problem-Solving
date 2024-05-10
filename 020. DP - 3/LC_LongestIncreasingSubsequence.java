import java.util.Arrays;
public class LC_LongestIncreasingSubsequence {
    public int binarySearchLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] lb = new int[n];
        int res = 0;
        for(int i : nums){
            int l = 0;
            int r = res;
            while (l < r){
                int m = (l + r) / 2;
                if(lb[m] < i) l = m + 1;
                else r = m;
            }
            lb[l] = i;
            if(l == res) res++;
        }
        return res;
    }

    public int memoizationLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++) res = Math.max(res, memoHelp(nums, n, i, dp));
        return res;
    }
    public int memoHelp(int[] nums, int n, int i, int[]dp){
        if(dp[i] != -1) return dp[i];

        int res = 1;
        for(int j = i + 1; j < n; j++){
            if(nums[j] > nums[i]){
                int temp = 1 + memoHelp(nums, n, j ,dp);
                res = Math.max(res, temp);
            }
        }
        dp[i] = res;
        return res;
    }
    public int dpSolLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];

        int res = 1;

        for(int i = 0; i < n; i++){
            int tempMax = 1;
            for(int j=i; j>=0; j--){
                if(nums[i] > nums[j]){
                    tempMax = Math.max(dp[j]+1, tempMax);
                }
            }
            dp[i] = tempMax;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums){
        return dpSolLIS(nums);
    }
}
