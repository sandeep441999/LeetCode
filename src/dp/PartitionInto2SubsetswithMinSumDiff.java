package dp;

public class PartitionInto2SubsetswithMinSumDiff {
    public int minDifference(int arr[]) {
        // code here
        int Sum = 0;
        for (int x : arr) {
            Sum += x;
        }

        int n = arr.length;
        // int[][] dp = new int[n][Sum+1];

        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // return f(n-1, 0, Sum, arr, dp);

        int[][] dp = new int[n + 1][Sum + 1];

        for (int cur = 0; cur <= Sum; cur++) {
            dp[0][cur] = Math.abs(Sum - 2 * cur);
        }

        for (int i = 1; i <= n; i++) {
            for (int cur = Sum; cur >= 0; cur--) {

                int pick = Integer.MAX_VALUE;
                if (cur + arr[i - 1] <= Sum) {
                    pick = dp[i - 1][cur + arr[i - 1]];
                }

                int notPick = dp[i - 1][cur];

                dp[i][cur] = Math.min(pick, notPick);
            }
        }

        return dp[n][0];

        // boolean[][] dp = new boolean[n + 1][Sum + 1];

        // for (int i = 0; i <= n; i++) {
        // dp[i][0] = true;
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int sum = 1; sum <= Sum; sum++) {
        // boolean pick = false;
        // if (arr[i - 1] <= sum) {
        // pick = dp[i - 1][sum - arr[i - 1]];
        // }

        // boolean notPick = dp[i - 1][sum];

        // dp[i][sum] = (pick || notPick);
        // }
        // }

        // int res = Integer.MAX_VALUE;

        // for(int i=0; i<=Sum/2; i++) {
        // if(dp[n][i] == true) {
        // int s1 = i;
        // int s2 = Sum - i;
        // res = Math.min(res, Math.abs(s1-s2));
        // }
        // }

        // return res;

    }

    public int f(int i, int cur, int total, int[] arr, int[][] dp) {

        if (i < 0) {
            int s1 = cur;
            int s2 = total - cur;

            return Math.abs(s2 - s1);
        }

        if (dp[i][cur] != -1)
            return dp[i][cur];

        int pick = f(i - 1, cur + arr[i], total, arr, dp);
        int notPick = f(i - 1, cur, total, arr, dp);

        return dp[i][cur] = Math.min(pick, notPick);
    }
}
