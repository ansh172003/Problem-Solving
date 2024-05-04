import java.util.Arrays;

public class LC_RemoveMaxEdges {
    private class UF{
        int n;
        int[] par;
        int[] rank;
        public UF(int n){
            this.n = n;
            for(int i = 0; i < n+1; i++) par[i] = i;
            Arrays.fill(rank, 1);
        }
        public int find(int n){
            while (n != this.par[n]){
                this.par[n] = this.par[this.par[n]];
                n = this.par[n];
            }
            return n;
        }

        public int union(int n1, int n2){
            int p1 = this.find(n1);
            int p2 = this.find(n2);
            if(p1 == p2) return 0;
            if(this.rank[p1] > this.rank[p2]){
                this.rank[p1] += this.rank[p2];
                this.par[p2] = p1;
            }
            else {
                this.rank[p2] += this.rank[p1];
                this.par[p1] = p2;
            }
            this.n -= 1;
            return 1;
        }
        public boolean isConnected(){
            return this.n <= 1;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF alice = new UF(n);
        UF bob = new UF(n);

        int res = 0;

        for(int[] edge : edges){
            int type = edge[0];
            int src = edge[1];
            int dest = edge[2];
            if(type == 3){
                res += (alice.union(src, dest) | bob.union(src, dest));
            }
        }
        for(int[] edge : edges){
            int type = edge[0];
            int src = edge[1];
            int dest = edge[2];
            if(type == 1){
                res += alice.union(src, dest);
            }
            else if(type == 2){
                res += bob.union(src, dest);
            }
        }

        if (bob.isConnected() && alice.isConnected()) return edges.length - res;
        else return -1;
    }
}
