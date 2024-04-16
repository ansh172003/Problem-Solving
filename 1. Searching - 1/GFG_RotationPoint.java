class GFG_RotationPoint {
    int findKRotation(int arr[], int n) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int minEl = Integer.MAX_VALUE;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[low] <= arr[mid]){
                if(minEl > arr[low]){
                    minEl = arr[low];
                    ans = low;
                    
                }
                low = mid + 1;
            } else{
                if(minEl >= arr[mid]){
                    minEl = arr[mid];
                    ans = mid;
                    
                }
                high = mid - 1;
            }
        }
        return ans;
    }
}