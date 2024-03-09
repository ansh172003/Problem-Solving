public class CWFindPeakElement {
    // O(n) brute force approach
    public static int bruteForce(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] > nums[1]) return nums[0];
        for(int i = 1; i < n-1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return nums[i];
        }
        return nums[n-1];
    }

    // O(logN) Binary Search approach
    public static int bsFindPeak(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] > nums[1]) return nums[0];
        if(nums[n-1] > nums[n-2]) return nums[n-1];
        int l = 0;
        int r = n - 1;
        while( l <= r){
            int mid = (l + r) / 2;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return nums[mid];
            if(nums[mid + 1] > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return nums[n-1];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,1};
        int ans = bsFindPeak(nums);
        int ans2 = bruteForce(nums);

        System.out.println(ans);
        System.out.println(ans2);
    }
}
