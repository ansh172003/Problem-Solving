import java.util.*;

public class IB_LargestDistance {
    static int ans;
    public static int solve(ArrayList<Integer> A) {
        ans = Integer.MIN_VALUE;
        int n = A.size();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int root = 0;
        if(n==1) return 0;

        for(int i=0; i<n; i++){
            if(A.get(i)==-1) root=i;
            else{
                adj.putIfAbsent(A.get(i), new ArrayList<>());
                adj.get(A.get(i)).add(i);
            }
        }

        dfs(root, adj);
        return ans;

    }

    public static int dfs(int root, Map<Integer, List<Integer>> adj) {
        if(adj.get(root)==null) return 1;
        List<Integer> neighbours = adj.get(root);
        int n = neighbours.size();
        for(int i=0; i<n; i++){
            neighbours.set(i, dfs(neighbours.get(i), adj));
        }
        neighbours.sort(Collections.reverseOrder());
        if(n>1){
            ans = Math.max(ans, neighbours.get(0)+ neighbours.get(1));
        }else {
            ans = Math.max(ans, neighbours.get(0));
        }

        return 1 + neighbours.get(0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-1);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(3);
        int ans = solve(A);
        System.out.println(ans);
    }
}

