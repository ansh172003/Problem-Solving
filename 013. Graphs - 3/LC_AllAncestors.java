import java.util.*;

public class LC_AllAncestors {
    public void dfs(List<Integer>[] graph, int u, int ancestor, boolean[] visited, List<List<Integer>> ans) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (visited[v])
                continue;
            ans.get(v).add(ancestor);
            dfs(graph, v, ancestor, visited, ans);
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i) {
            ans.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < n; i++)
            dfs(graph, i, i, new boolean[n], ans);

        return ans;


    }
}
