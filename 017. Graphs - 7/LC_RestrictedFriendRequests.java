import java.util.*;

class LC_RestrictedFriendRequests {
    private static class UF {
        List<Set<Integer>> rest;
        int [] rank;
        int [] par;

        public UF(int n, int[][] res){
            this.par = new int [n];
            this.rank = new int [n];
            this.rest = new ArrayList<>(n);
            for(int i =0; i <n; i++) {
                this.par[i] = i;
                this.rank[i] = 1;
                this.rest.add(new HashSet<>());
            }
            for (int[] i: res){
                this.rest.get(i[0]).add(i[1]);
                this.rest.get(i[1]).add(i[0]);
            }
        }

        private int find(int node) {
            int root = node;
            while (par[root] != root) {
                root = par[root];
            }
            while (par[node] != root) {
                int next = par[node];
                par[node] = root;
                node = next;
            }
            return root;
        }

        private boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 == p2) return true;
            if (checkRestrictions(p1, p2)){
                if (rank[p1] > rank[p2]){
                    rank[p1] += rank[p2];
                    par[p2] = p1;
                    for(int node: rest.get(p2)) rest.get(p1).add(find(node));
                } else{
                    rank[p2] += rank[p1];
                    par[p1] = p2;
                    for(int node: rest.get(p1)) rest.get(p2).add(find(node));
                }
                return true;
            }
            return false;
        }
        private boolean checkRestrictions(int p1, int p2) {
            if (rest.get(p1).contains(p2))
                return false;
            else return !rest.get(p2).contains(p1);
        }
    }
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        if (restrictions.length == 0){
            boolean [] queries = new boolean[requests.length];
            Arrays.fill(queries, true);
            return queries;
        }
        UF dsu = new UF(n, restrictions);
        boolean [] queries = new boolean [requests.length];
        for (int i =0; i < requests.length; i++){
            queries[i] = dsu.union(requests[i][0], requests[i][1]);
        }
        return queries;
    }
}