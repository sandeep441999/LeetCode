package dp;

public class Knapsack01Problem {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        // int[][] dp = new int[n][W+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return f(n-1, W, val, wt, dp);
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                int pick = Integer.MIN_VALUE;

                if (w - wt[i - 1] >= 0) {
                    pick = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                }

                int notPick = dp[i - 1][w];

                dp[i][w] = Math.max(pick, notPick);
            }
        }

        return dp[n][W];
    }

    public int f(int i, int w, int[] val, int[] wt, int[][] dp) {
        if (i < 0) {
            if (w < 0)
                return Integer.MIN_VALUE;
            return 0;
        }

        if (dp[i][w] != -1)
            return dp[i][w];

        int pick = Integer.MIN_VALUE;

        if (w - wt[i] >= 0) {
            pick = val[i] + f(i - 1, w - wt[i], val, wt, dp);
        }

        int notPick = f(i - 1, w, val, wt, dp);

        return dp[i][w] = Math.max(pick, notPick);
    }
}
