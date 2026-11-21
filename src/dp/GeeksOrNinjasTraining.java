package dp;

public class GeeksOrNinjasTraining {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        // int[][] dp = new int[n][4];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // return f(n-1, mat, 3, dp);

        int[][] dp = new int[n + 1][4];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][1], mat[0][0]);
        dp[0][3] = Math.max(mat[0][1], Math.max(mat[0][0], mat[0][2]));

        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < 4; prev++) {
                int maxi = 0;

                for (int j = 0; j < 3; j++) {
                    if (j != prev) {
                        int points = mat[i][j] + dp[i - 1][j];
                        maxi = Math.max(maxi, points);
                    }
                }
                dp[i][prev] = maxi;
            }
        }
        return dp[n - 1][3];

    }

    public int f(int i, int mat[][], int prev, int[][] dp) {
        if (i < 0)
            return 0;

        int maxi = 0;
        if (dp[i][prev] != -1)
            return dp[i][prev];

        for (int j = 0; j < 3; j++) {
            if (j != prev) {
                int points = mat[i][j] + f(i - 1, mat, j, dp);
                maxi = Math.max(maxi, points);
            }
        }

        return dp[i][prev] = maxi;
    }
}
