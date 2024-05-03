import java.util.*;

public class LC_GraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i]==-1)
                if(!dfs(graph, color, i, 0)) return false;
        }

        return true;
    }
    public boolean dfs(int[][] graph, int[] color, int i, int currColor){
        color[i] = currColor;
        for(int j: graph[i]){
            if(color[j]==-1){
                if(!dfs(graph, color, j, 1 - currColor)) return false;
            }
            else if(color[j]==currColor){
                return false;
            }
        }
        return true;
    }
}
