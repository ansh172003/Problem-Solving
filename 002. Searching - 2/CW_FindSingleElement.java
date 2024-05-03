public class CW_FindSingleElement {
    // O(n) approach using XOR Operation
    public static void xorCheck(int [] nums){
        int xor = 0;
        for(int i : nums){
            xor = xor ^ i;
        }
        System.out.println(xor);
    }

    // Log(n) approach using Binary Search
    public static int bsCheck(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        int l = 1;
        int r = n - 2;
        while( l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if((mid % 2 != 0 && nums[mid -1] == nums[mid]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) l = mid + 1;
            else r = mid -1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        xorCheck(nums);
        int ans = bsCheck(nums);
        System.out.println(ans);
    }
}
