package dp;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // return f(m-1, n-1, grid, dp);

        // int[][] dp = new int[m+1][n+1];
        // for(int j=0; j<=n; j++) {
        // dp[0][j] = (int) 1e7;
        // }

        // for(int i=0; i<=m; i++) {
        // dp[i][0] = (int) 1e7;
        // }
        // dp[1][1] = grid[0][0];
        int[] prev = new int[n + 1];
        Arrays.fill(prev, (int) 1e7);

        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            cur[0] = (int) 1e7;
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    cur[j] = grid[0][0];
                    continue;
                }
                cur[j] = grid[i - 1][j - 1] + Math.min(prev[j], cur[j - 1]);
            }
            prev = cur;
        }
        return prev[n];
    }

    public int f(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0)
            return (int) 1e7;
        if (i == 0 && j == 0)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int sum = grid[i][j] + Math.min(f(i - 1, j, grid, dp), f(i, j - 1, grid, dp));
        return dp[i][j] = sum;
    }
}
