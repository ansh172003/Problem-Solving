import java.util.ArrayList;
import java.util.List;

public class LC_NumberOfProvinces {
    public void dfs(List<List<Integer>> gr, int node, int[] visited){
        visited[node] = 1;
        for(int n : gr.get(node)){
            if(visited[n] == 0) dfs(gr, n, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        int[] visited = new int[n];
        List<List<Integer>> gr = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            gr.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    gr.get(i).add(j);
                    gr.get(j).add(i);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                res++;
                dfs(gr, i, visited);
            }
        }

        return  res;

    }
}
