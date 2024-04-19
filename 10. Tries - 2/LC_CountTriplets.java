public class LC_CountTriplets {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++) {
            int t=arr[i];
            for(int j=i+1;j<n;j++) {
                t=t^arr[j];
                if(t==0) ans+=j-i;
            }
        }
        return ans;
    }
}
