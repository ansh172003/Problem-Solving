import java.util.*;

public class LC_MinCostToConnectAll {
    static class Data{
        int vertices;
        int distance;

        public Data(int _dist, int _vert){
            this.vertices = _vert;
            this.distance = _dist;
        }
    }
    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Data> q = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        q.offer(new Data(0, 0));
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        while (visited.size() < n) {
            Data d = q.poll();
            int dist = d.distance;
            int vert = d.vertices;
            if (visited.contains(vert)) continue;
            visited.add(vert);
            res += dist;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    int[] p1 = points[i];
                    int[] p2 = points[vert];
                    int newDist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                    q.offer(new Data (newDist, i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] p = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int ans = minCostConnectPoints(p);
        System.out.println(ans);
    }
}
