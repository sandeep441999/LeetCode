package graphs;

import java.util.ArrayDeque;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int[] d : dir) {
                int r = node[0] + d[0];
                int c = node[1] + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && dist[r][c] == -1) {
                    dist[r][c] = dist[node[0]][node[1]] + 1;
                    q.offer(new int[] { r, c });
                }
            }
        }

        return dist;
    }
}
