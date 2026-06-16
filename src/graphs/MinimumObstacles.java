package graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumObstacles {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // int[][] dist = new int[rows][cols];

        // for(int[] row : dist) {
        // Arrays.fill(row, Integer.MAX_VALUE);
        // }
        // dist[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        q.offerFirst(new int[] { 0, 0, 0 }); // r, c, cost

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];

            if (r == rows - 1 && c == cols - 1)
                return cost;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                // int n_cost = cost + (grid[nr][nc] == 1 ? 1 : 0);
                int w = grid[nr][nc];
                int n_cost = cost + w;

                if (w == 1) {
                    q.offerLast(new int[] { nr, nc, n_cost });
                } else {
                    q.offerFirst(new int[] { nr, nc, n_cost });
                }

                // if(n_cost < dist[nr][nc]) {
                // dist[nr][nc] = n_cost;
                // if(grid[nr][nc] == 1) {
                // q.offerLast(new int[]{nr, nc, n_cost});
                // } else {
                // q.offerFirst(new int[]{nr, nc, cost});
                // }
                // }

            }

        }

        // return dist[rows-1][cols-1];
        return -1;
    }
}
