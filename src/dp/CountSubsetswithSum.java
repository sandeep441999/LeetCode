package dp;

public class CountSubsetswithSum {
    static int perfectSum(int[] arr, int target) {
        // code here
        int n = arr.length;
        // int[][] dp = new int[n][target+1];

        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return f(n-1, target, arr, dp);

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int t = 0; t <= target; t++) {
                int pick = 0;
                if (arr[i - 1] <= t)
                    pick = dp[i - 1][t - arr[i - 1]];
                int notPick = dp[i - 1][t];

                dp[i][t] = pick + notPick;
            }
        }

        return dp[n][target];
    }

    static int f(int i, int target, int[] arr, int[][] dp) {

        if (target < 0)
            return 0;

        if (i < 0) {
            return target == 0 ? 1 : 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target];

        int pick = f(i - 1, target - arr[i], arr, dp);
        int notPick = f(i - 1, target, arr, dp);

        return dp[i][target] = pick + notPick;
    }
}
