public class LC_MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int totalMultiplication = 1;
        for (int num : nums) {
        totalMultiplication *= num;
            max = Math.max(max, totalMultiplication);
            if (num == 0) totalMultiplication = 1;
        }
        totalMultiplication = 1;
        for(int i = nums.length-1; i>=0; i--){
            totalMultiplication *= nums[i];
            max = Math.max(max, totalMultiplication);
            if(nums[i] == 0) totalMultiplication = 1;
        }
        return max;
    }
}
