package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[] { 0, 0, 0 });

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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
                int newr = r + d[0];
                int newc = c + d[1];

                if (newr < 0 || newc < 0 || newr == rows || newc == cols)
                    continue;

                int diff = Math.max(Math.abs(heights[r][c] - heights[newr][newc]), w);

                if (diff < dist[newr][newc]) {
                    dist[newr][newc] = diff;
                    pq.offer(new int[] { newr, newc, diff });
                }

            }
        }

        return 0;
    }
}
