import java.util.LinkedList;
import java.util.Queue;

public class LC_RottenOranges {
    private static class Data{
        int r;
        int c;
        int t;
        Data(int _r, int _c, int _t){
            this.r = _r; this.c = _c; this.t = _t;
        }
    }
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            Queue<Data> q = new LinkedList<>();
            int[][] vis = new int[n][m];
            int fresh = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Data(i, j, 0));
                        vis[i][j] = 2;
                    } else vis[i][j] = 0;

                    if (grid[i][j] == 1) fresh++;
                }
            }
            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};
            int finalTime = 0;
            int selfRotten = 0;

            while (!q.isEmpty()) {
                int r = q.peek().r;
                int c = q.peek().c;
                int t = q.peek().t;
                finalTime = Math.max(finalTime, t);
                q.remove();
                for (int i = 0; i < 4; i++) {
                    int nR = r + deltaRow[i];
                    int nC = c + deltaCol[i];
                    boolean checkBounds = nR >= 0 && nR < n && nC >= 0 && nC < m;

                    if (checkBounds && vis[nR][nC] == 0 && grid[nR][nC] == 1) {
                        q.add(new Data(nR, nC, t + 1));
                        vis[nR][nC] = 2;
                        selfRotten++;
                    }
                }
            }
            if (selfRotten != fresh) return -1;
            return finalTime;
        }
}
