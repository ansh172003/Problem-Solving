import java.util.Arrays;

public class LC_JumpGame2 {
    public int memoApproach(int [] nums){
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, - 1);
        int sol = memoApproachHelp(0, n-1, nums, memo);
        return sol;
    }
    public int memoApproachHelp(int i, int n, int[] nums, int[] memo){
        if(i >= n) return 0;
        if(memo[i] == -1){
            int m = n;
            for(int j = 1; j <= nums[i]; j++){
                int jump = memoApproachHelp(i+j, n, nums, memo) + 1;
                m=Math.min(jump, m);
            }
            memo[i]=m;
            return memo[i];
        }
        return memo[i];
    }
    public int dpApproach(int[] nums){
        int n = nums.length;
        if (n <= 1) return 0;

        int c = 0, lIdx = 0, rIdx = 0;
        int max = nums[0];

        while (lIdx < n) {
            lIdx = rIdx + 1;
            rIdx = Math.min(max, n - 1);
            c++;

            if (rIdx >= n - 1) return c;

            while (lIdx <= rIdx) {
                max = Math.min(Math.max(max, lIdx + nums[lIdx]), n - 1);
                lIdx++;
            }
        }
        return c;
    }
    public int jump(int[] nums) {
        return memoApproach(nums);
    }
}
