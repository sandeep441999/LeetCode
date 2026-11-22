package dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m;i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return dfs(0, 0, obstacleGrid, dp);

        // int[][] dp = new int[m+1][n+1];
        // dp[m-1][n-1] = 1;
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                // if(obstacleGrid[i][j] == 1) {
                // dp[i][j] = 0;
                // continue;
                // }
                // dp[i][j] = dp[i+1][j] + dp[i][j+1];

                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j + 1];
                }
            }
        }

        return dp[0];

        // return dp[0][0];
    }

    public int dfs(int i, int j, int[][] obstacleGrid, int[][] dp) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (i >= m || j >= n)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = dfs(i + 1, j, obstacleGrid, dp) + dfs(i, j + 1, obstacleGrid, dp);
    }
}
