import java.util.Arrays;


public class LC_FindRedundantConnectionI {
    private int find(int n, int[] par){
        int p = par[n];
        while (p != par[p]){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
    private boolean union(int n1, int n2, int[] par, int[] rank){
        int p1 = find(n1, par);
        int p2 = find(n2, par);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];
        Arrays.fill(rank, 1);
        for(int i = 0; i < n+1; i++) par[i] = i;

        for(int[] edge : edges){
            if(!union(edge[0], edge[1], par, rank)) return edge;
        }
        return new int[n];
    }
}
