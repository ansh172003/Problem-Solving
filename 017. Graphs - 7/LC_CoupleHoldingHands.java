public class LC_CoupleHoldingHands {
    public int minSwapsCouples(int[] row){
        int n = row.length;
        int ans = 0;
        for(int i=0;i<n;i+=2){
            int c = row[i]%2==0 ? row[i]+1 : row[i]-1;
            if(row[i+1]!=c){
                ans++;
                for(int j=i+1;j<n;j++){
                    if(row[j]==c){
                        row[j]=row[i+1];
                        row[i+1]=c;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
