class LCSearchRotatedSorted {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){     // left sorted
                if(nums[low] <= target && nums[mid]>=target) high = mid - 1;      // in left sorted
                else low = mid + 1;                                             // outside left sorted
            } else{                         //right sorted
                if(nums[high] >= target && nums[mid] <= target) low = mid + 1;  // in right sorted
                else high = mid - 1;                                            // outside right sorted
            }
        }
        return -1;
    }
}