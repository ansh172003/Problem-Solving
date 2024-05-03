import java.util.*;

public class GFG_StronglyConnected {
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++) if(!vis[i]) dfs(adj, i, st, vis);

        vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

        for(int i=0; i<n; i++)adj2.add(new ArrayList<>());
        for(int i=0; i<adj.size(); i++){
            for(int k: adj.get(i)){
                adj2.get(k).add(i);
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                iterator(adj2, curr, vis);
                res++;
            }
        }
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean[] vis){
        vis[node] = true;
        for(int i: adj.get(node)){
            if(!vis[i]) dfs(adj, i, st, vis);
        }
        st.push(node);
    }
    public void iterator(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis){
        vis[node] = true;
        for(int i: adj.get(node)){
            if(!vis[i]) iterator(adj, i, vis);
        }
    }
}
