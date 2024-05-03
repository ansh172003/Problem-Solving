import java.util.*;

public class GFG_Nearest1 {
    static class Node {
        int first;
        int second;
        int third;
        Node(int _first, int _second, int _third) {
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
    public int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for(int i = 0;i<4;i++) {
                int nR = row + deltaRow[i];
                int nC = col + deltaCol[i];
                if(nR >= 0 && nR < n && nC >= 0 && nC < m
                        && vis[nR][nC] == 0)  {
                    vis[nR][nC] = 1;
                    q.add(new Node(nR, nC, steps + 1));
                }
            }
        }
        return dist;
    }
}
