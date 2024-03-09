public class CWFindSingleElement {
    // O(n) approach using XOR Operation
    public static void xorCheck(int [] nums){
        int xor = 0;
        for(int i : nums){
            xor = xor ^ i;
        }
        System.out.println(xor);
    }

    // Log(n) approach using Binary Search
    public static void bsCheck(int[] nums){
        int n = nums.length;
        if(n == 1) return;
        if(nums[0] != nums[1]){
            System.out.println(nums[0]);
            return;
        }
        if(nums[n-1] != nums[n-2]){
            System.out.println(nums[n-1]);
            return;
        }
        int l = 0;
        int r = n - 1;
        int mid = 0;
        while( l <= r){
            mid = (l + r) / 2;
            if(nums[mid] == nums[mid-1]){
                mid = mid-1;
                if(mid%2 == 0) l = mid+2;
            }
            else r = mid-1;
        }
        System.out.println(nums[mid]);
    }
    public static void main(String[] args){
        int[] nums = {3,3,9,1,1,8,8,10,10,6,6,2,2,4,4};
        xorCheck(nums);
        bsCheck(nums);
    }
}
