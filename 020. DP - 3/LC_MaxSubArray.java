public class LC_MaxSubArray {
    public int KadaneApproach(int[] nums) {
        int max = Integer.MIN_VALUE;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
            max = Math.max(max, totalSum);
            if (totalSum < 0) totalSum = 0;
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        return KadaneApproach(nums);


    }
}
