import java.util.ArrayList;
import java.util.List;

public class LC_FindIfPathExists {
    public boolean dfs(List<List<Integer>> gr, int src, int dest, int[] visited){
        if(src == dest) return true;

        visited[src] = 1;
        for(int n : gr.get(src)){
            if(visited[n] == 0){
                if(dfs(gr, n, dest, visited)) return  true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int src, int dest){
        List<List<Integer>> gr = new ArrayList<>();
        int [] visited = new int[n];

        for(int i = 0; i < n; i++){
            gr.add(new ArrayList<>());
        }
        for(int[] e : edges){
            gr.get(e[0]).add(e[1]);
            gr.get(e[1]).add(e[0]);
        }

        return dfs(gr, src, dest, visited);
    }
}
