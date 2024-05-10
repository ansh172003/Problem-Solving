public class LC_HouseRobber1 {

    public int recursiveApproach(int[] nums){
        int n = nums.length;
        return recursiveApproach(nums, n-1);
    }
    public int recursiveApproach(int[] nums, int n){
        if(n<0) return 0;
        int t1 = recursiveApproach(nums, n-1);
        int t2 = recursiveApproach(nums, n-2) + nums[n];
        return Math.max(t1, t2);
    }

    public int memoApproach(int[] nums){
        int n = nums.length;
        int[] memo = new int[n+1];
        for(int i = 0; i <= n; i++) memo[i] = -1;
        return memoApproachHelp(nums, n-1, memo);
    }
    public int memoApproachHelp(int[] nums, int i, int[] memo){
        if(i<0) return 0;
        if(memo[i] == -1){
            int l1 = memoApproachHelp(nums, i-1, memo);
            int l2 = memoApproachHelp(nums, i-2, memo) + nums[i];
            int res = Math.max(l1, l2);
            memo[i] = res;
        }
        return memo[i];
    }
    public int bottomUpApproach(int[] nums){
        int n = nums.length;
        int[] cache = new int[n];
        if( n == 1) return nums[0];

        cache[0] = nums[0];
        if(nums[0] > nums[1]) cache[1] = nums[0];
        else cache[1] = nums[1];

        for(int i=2;i<n;i++){
            int c = cache[i-2] + nums[i];
            cache[i]=Math.max(cache[i-1], c);
        }
        return cache[n-1];
    }
    public int spaceOptimized(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];

        int p1 = nums[0];
        int p2;
        if(nums[0] > nums[1]) p2 = nums[0];
        else p2 = nums[1];
        int p3 = 0;
        for(int i = 2; i < n; i++){
            p3 = Math.max(p2, p1+nums[i]);
            p1 = p2;
            p2 = p3;
        }
        return p2;
    }
    public int rob(int[] nums) {
        // return recursiveApproach(nums);
        // return memoApproach(nums);
        return bottomUpApproach(nums);
    }
}
