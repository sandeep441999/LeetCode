package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;
            for (int i = 0; i < size; i++) {
                int[] val = q.poll();
                int row = val[0], col = val[1];
                for (int[] d : dir) {
                    int r = row + d[0];
                    int c = col + d[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        q.offer(new int[] { r, c });
                        grid[r][c] = 2;
                        rotten = true;
                        fresh--;
                    }
                }
            }
            if (rotten) {
                time += 1;
            }
        }
        return fresh == 0 ? time : -1;
    }
}
