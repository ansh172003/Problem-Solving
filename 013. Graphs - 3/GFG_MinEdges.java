import java.util.*;

public class GFG_MinEdges {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        HashMap<ArrayList<Integer>,Integer> exists = new HashMap<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(new ArrayList<>());
        for(int[] edge : edges){
            arr.get(edge[0]-1).add(edge[1]-1);
            arr.get(edge[1]-1).add(edge[0]-1);
            exists.put(new ArrayList<>(Arrays.asList(edge[0]-1,edge[1]-1)),1);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src-1,0});
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src-1] = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] u = q.poll();
                if(u[0] == dst-1){
                    return u[1];
                }
                for(int v : arr.get(u[0])){
                    int c = u[1];
                    if(!exists.containsKey(new ArrayList<>(Arrays.asList(u[0],v)))){
                        c++;
                    }
                    if(dis[v] > c){
                        dis[v] = c;
                        if(c == u[1]){
                            q.addFirst(new int[]{v,c});
                        }
                        else{
                            q.addLast(new int[]{v,c});
                        }
                    }
                }
            }
        }
        return -1;
        // code here
    }
}
