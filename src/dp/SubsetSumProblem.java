package dp;

public class SubsetSumProblem {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;

        // int[][] dp = new int[n][sum+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return f(n-1, arr, sum, dp);

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean pick = false;
                if (arr[i - 1] <= j) {
                    pick = dp[i - 1][j - arr[i - 1]];
                }
                boolean notPick = dp[i - 1][j];

                dp[i][j] = (pick || notPick);
            }
        }

        return dp[n][sum];
    }

    static public boolean f(int i, int arr[], int sum, int[][] dp) {

        if (sum == 0)
            return true;

        if (i < 0)
            return false;

        if (dp[i][sum] != -1)
            return dp[i][sum] == 1;

        boolean pick = false;
        if (arr[i] <= sum) {
            pick = f(i - 1, arr, sum - arr[i], dp);
        }
        boolean notPick = f(i - 1, arr, sum, dp);

        dp[i][sum] = (pick || notPick) ? 1 : 0;

        return dp[i][sum] == 1;
    }
}
