package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;

        // for(int i=0;i<m; i++) {
        // for(int j=0; j<n; j++) {
        // if(grid[i][j] == '1') {
        // bfs(i,j, grid);
        // islands+=1;
        // }
        // }
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands += 1;
                }
            }
        }
        return islands;
    }

    public void dfs(int i, int j, char[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        grid[i][j] = '0';
        for (int[] d : dir) {
            int r = d[0] + i;
            int c = d[1] + j;

            if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == '1') {
                grid[r][c] = '0';
                dfs(r, c, grid);
            }
        }
    }

    public void bfs(int i, int j, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        q.offer(new int[] { i, j });
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            int[] val = q.poll();
            int row = val[0], col = val[1];

            for (int[] d : dir) {
                int r = d[0] + row;
                int c = d[1] + col;

                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                    q.offer(new int[] { r, c });
                    grid[r][c] = '0';
                }
            }
        }

    }
}
