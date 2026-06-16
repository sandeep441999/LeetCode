package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinCostValidPathGrid {
    public int minCost(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 0 }); // r, c, cost

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];

            if (r == rows - 1 && c == cols - 1)
                return cost;

            int move = grid[r][c] - 1;

            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;

                int n_cost = dist[r][c] + (i == move ? 0 : 1);

                if (n_cost < dist[nr][nc]) {
                    dist[nr][nc] = n_cost;
                    if (i == move) {
                        q.offerFirst(new int[] { nr, nc, n_cost });
                    } else {
                        q.offerLast(new int[] { nr, nc, n_cost });
                    }
                }

            }
        }

        return dist[rows - 1][cols - 1];
    }
}
