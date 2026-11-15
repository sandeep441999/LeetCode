package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofDistinctIslands {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L') {
                    grid[i][j] = 'W';
                    bfs(i, j, grid, set);
                }
            }
        }
        return set.size();
    }

    public void bfs(int i, int j, char[][] grid, Set<String> set) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        List<String> shape = new ArrayList<>();

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });

        while (!q.isEmpty()) {
            int[] node = q.poll();

            shape.add((node[0] - i) + "," + (node[1] - j) + ";");
            for (int[] d : dir) {
                int r = d[0] + node[0];
                int c = d[1] + node[1];

                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 'L') {
                    grid[r][c] = 'W';
                    q.offer(new int[] { r, c });
                }
            }
        }
        // Collections.sort(shape);

        set.add(String.join(";", shape));
    }
}
