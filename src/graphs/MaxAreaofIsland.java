package graphs;

import java.util.ArrayDeque;

public class MaxAreaofIsland {
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int n, m;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        // boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if(grid[i][j] == 1 && !visited[i][j]) {
                // count = Math.max(count, bfs(i, j, grid, visited));
                // }
                if (grid[i][j] == 1) {
                    count = Math.max(count, bfs(i, j, grid));
                }
            }
        }

        return count;
    }

    // public int bfs(int i, int j, int[][] grid, boolean[][] visited) {

    public int bfs(int i, int j, int[][] grid) {
        // visited[i][j] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        grid[i][j] = 0;
        int cur = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            cur++;
            for (int[] d : dir) {
                int r = node[0] + d[0];
                int c = node[1] + d[1];

                // if(r>=0 && c>=0 && r < n && c < m && grid[r][c] == 1 && !visited[r][c])
                if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                    q.offer(new int[] { r, c });
                    grid[r][c] = 0;
                    // visited[r][c] = true;
                }
            }

        }

        return cur;
    }
}
