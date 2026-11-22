package dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        // int N = m + n -2;
        // int r = Math.min(m-1, n-1);

        // long res = 1;
        // for(int i=1; i<=r; i++) {
        // res = res * (N-r+i)/i;
        // }
        // return (int) res;
        int[][] dp = new int[m + 1][n + 1];
        // for(int i=0; i<m; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // return dfs(0, 0, m, n, dp);
        dp[m - 1][n - 1] = 1;
        // dp[m-1][n] = 1;
        // dp[m][n-1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    public int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = dfs(i + 1, j, m, n, dp) + dfs(i, j + 1, m, n, dp);

    }
}
