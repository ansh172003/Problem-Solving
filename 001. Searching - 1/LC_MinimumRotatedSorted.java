class LC_MinimumRotatedSorted {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while( low <= high){
            int mid = (low + high) / 2;
            if(nums[low] <= nums[mid]){ // Left Sorted
                min = (min < nums[low]) ? min : nums[low];
                low = mid + 1;
            } else {                    // Right sorted
                min = (min < nums[mid]) ? min : nums[mid];
                high = mid - 1;
            }
        }
        return min;
    }
}