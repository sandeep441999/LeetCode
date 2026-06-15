package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInWater {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        dist[0][0] = grid[0][0];

        pq.offer(new int[] { 0, 0, grid[0][0] });

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int res = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int w = cur[2];

            if (w > dist[r][c])
                continue;
            if (r == rows - 1 && c == cols - 1)
                return w;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;
                int val = Math.max(w, grid[nr][nc]);

                if (val < dist[nr][nc]) {
                    dist[nr][nc] = val;
                    pq.offer(new int[] { nr, nc, val });
                }
            }
        }

        return res;
    }
}
