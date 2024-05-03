import java.util.ArrayList;
import java.util.Arrays;

public class GFG_DetectCycle {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int[] currPath){
        vis[node] = 1;
        currPath[node] = 1;
        for(int n : adj.get(node)){
            if(vis[n] == 0) {
                if (dfs(adj, n, vis, currPath))
                    return true;
            }
            else if(currPath[n] == 1){
                return true;
            }
        }
        currPath[node] = 0;
        return false;
    }
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] currPath = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(dfs(adj, i, vis, currPath) == true) return true;
            }
        }
        return false;
    }
}
