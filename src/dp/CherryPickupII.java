package dp;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // int[][][] dp = new int[m][n][n];
        // for(int i=0; i<m; i++) {
        // for(int j=0; j<n; j++) {
        // Arrays.fill(dp[i][j], -1);
        // }
        // }
        // return f(0, 0, n-1, grid, dp);
        int[][][] dp = new int[m + 1][n][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j1 = n - 1; j1 >= 0; j1--) {
                for (int j2 = n - 1; j2 >= 0; j2--) {
                    int count = 0;

                    if (j1 == j2) {
                        count = grid[i][j1];
                    }
                    if (j1 != j2) {
                        count = grid[i][j1] + grid[i][j2];
                    }
                    int maxi = Integer.MIN_VALUE;
                    int col1 = j1, col2 = j2;
                    for (int k1 = -1; k1 <= 1; k1++) {
                        col1 = j1;
                        col1 += k1;
                        for (int k2 = -1; k2 <= 1; k2++) {
                            col2 = j2;
                            col2 += k2;
                            if (col1 < 0 || col2 < 0 || col1 >= n || col2 >= n)
                                continue;
                            maxi = Math.max(maxi, dp[i + 1][col1][col2]);
                        }
                    }
                    count += maxi;

                    dp[i][j1][j2] = count;
                }
            }
        }

        return dp[0][0][n - 1];
    }

    public int f(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int m = grid.length, n = grid[0].length;

        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n)
            return (int) -1e5;

        if (i == m)
            return 0;

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int count = 0;

        if (j1 == j2) {
            count = grid[i][j1];
        }
        if (j1 != j2) {
            count = grid[i][j1] + grid[i][j2];
        }
        int maxi = Integer.MIN_VALUE;
        int col1 = j1, col2 = j2;
        for (int k1 = -1; k1 <= 1; k1++) {
            col1 = j1;
            col1 += k1;
            for (int k2 = -1; k2 <= 1; k2++) {
                col2 = j2;
                col2 += k2;
                maxi = Math.max(maxi, f(i + 1, col1, col2, grid, dp));
            }
        }
        count += maxi;

        return dp[i][j1][j2] = count;
    }
}
