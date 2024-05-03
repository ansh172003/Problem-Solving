import java.util.*;
public class LC_ShortestCycle {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) ans = Math.min(ans, bfs(n, adj, i));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int bfs(int n, List<List<Integer>> adj, int node){
        int[] visited = new int[n];
        int[] parent = new int[n];

        Arrays.fill(visited, -1);
        visited[node] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int adjacent: adj.get(curr)){
                if(visited[adjacent] == -1){
                    visited[adjacent] = visited[curr] + 1;
                    q.add(adjacent);
                    parent[adjacent] = curr;
                } else if(parent[curr] != adjacent)
                        ans = Math.min(ans, visited[adjacent] + visited[curr]+1);
            }
        }

        return ans;

    }

}
