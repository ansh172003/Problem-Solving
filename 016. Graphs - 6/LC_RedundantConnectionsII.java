import java.util.Arrays;

public class LC_RedundantConnectionsII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n+1];
        Arrays.fill(parent ,-1);

        int[] ds = new int[n+1];

        int first = -1, second = -1, last = -1;

        for(int i = 0; i < n; i++){
            int p = edges[i][0];
            int c = edges[i][1];

            if(parent[c] != -1){
                first = parent[c];
                second = i;
                continue;
            }

            parent[c] = i;
            int p2 = find(ds, p);
            if(p2 == c)
                last = i;
            else ds[c] = p2;
        }
        if(last == -1) return edges[second];
        if(second == -1)return edges[last];
        return edges[first];
    }
    private int find(int[] ds, int p){
        if(ds[p] == 0) return p;
        else{
            int x = find(ds, ds[p]);
            return ds[p] = x;
        }
    }

}
