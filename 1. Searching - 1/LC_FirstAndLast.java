class LC_FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int fOcc = -1;
        int lOcc = -1;
        while( low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                fOcc = mid;
                high = mid - 1;
            } 
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        low = 0;
        high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                lOcc = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        int[] ans = {fOcc, lOcc};
        return ans;
    }
}