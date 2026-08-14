package graphs;

import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {
    private final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo));
            }
        }
        return res;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] memo) {
        int n = matrix.length, m = matrix[0].length;
        int val = matrix[i][j];
        int cur = 1;

        if (memo[i][j] != -1)
            return memo[i][j];

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r >= 0 && r < n && c >= 0 && c < m && matrix[r][c] > val) {
                cur = Math.max(cur, 1 + dfs(r, c, matrix, memo));
            }
        }
        memo[i][j] = cur;

        return cur;
    }
}
