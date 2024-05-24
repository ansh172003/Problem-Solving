import java.util.Arrays;
import java.util.List;

public class LC_LengthOfLISThatSumsToTarget {
    public int recursiveApproach(List<Integer> list, int st, int target){
        if(target == 0)return 0;
        if(target < 0 || st >= list.size()) return Integer.MIN_VALUE;
        int pick=recursiveApproach(list,st+1,target-list.get(st)) + 1;
        int notPick=recursiveApproach(list,st+1,target);
        return Math.max(pick,notPick);
    }
    int[][] memo;
    public int memoizationApproach(List<Integer> list, int st, int target){
        if(target == 0)return 0;
        if(target < 0 || st >= list.size()) return Integer.MIN_VALUE;
        if(memo[st][target]!=-1)return memo[st][target];
        int pick=1+ memoizationApproach(list,st+1,target-list.get(st));
        int notPick= memoizationApproach(list,st+1,target);
        return memo[st][target]=Math.max(pick,notPick);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        memo = new int[nums.size() + 1][target];
        for(int[] arr:memo) Arrays.fill(arr,-1);
        int ans = memoizationApproach(nums,0,target);
        return ans<=0 ?-1 : ans;
    }
}
