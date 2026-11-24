package dp;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        // int[][] dp = new int[n][n];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], (int) 1e7);
        // }
        // for(int i=0; i<n; i++) {
        // res = Math.min(res, f(0, i, matrix, dp));
        // }

        // for(int i=n-1; i>=0; i--) {
        // res = Math.min(res, f(n-1, i, matrix, dp));
        // }

        // return res;

        // O(N^2) space
        // int[][] dp = new int[n][n];
        // for(int j=0; j<n; j++) {
        // dp[0][j] = matrix[0][j];
        // }

        // O(N) space
        int[] prev = new int[n];
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                int ld = (int) 1e7;
                if (j - 1 >= 0) {
                    ld = prev[j - 1];
                }
                int rd = (int) 1e7;
                if (j + 1 < n) {
                    rd = prev[j + 1];
                }

                cur[j] = matrix[i][j] + Math.min(ld, Math.min(prev[j], rd));
            }
            prev = cur;
        }

        // for(int j=0; j<n; j++) {
        // res = Math.min(res, dp[n-1][j]);
        // }
        for (int j = 0; j < n; j++) {
            res = Math.min(res, prev[j]);
        }

        return res;
    }

    public int f(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        if (j < 0 || j >= n)
            return (int) 1e5;
        // if(i == n) return 0;
        if (i == 0)
            return matrix[i][j];

        if (dp[i][j] != (int) 1e7)
            return dp[i][j];

        // int sum = matrix[i][j] + Math.min(f(i+1, j-1, matrix, dp), Math.min(f(i+1, j,
        // matrix, dp), f(i+1, j+1, matrix, dp)));

        int sum = matrix[i][j]
                + Math.min(f(i - 1, j - 1, matrix, dp), Math.min(f(i - 1, j, matrix, dp), f(i - 1, j + 1, matrix, dp)));

        return dp[i][j] = sum;
    }
}
