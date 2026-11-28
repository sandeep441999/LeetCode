package dp;

public class PartitionswithGivenDifference {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        // int[][] dp = new int[n][total+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return f(n-1, 0, total, diff, arr, dp);

        int[][] dp = new int[n + 1][total + 1];
        for (int cur = 0; cur <= total; cur++) {
            int val = total - 2 * cur;
            if (val == diff) {
                dp[0][cur] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int cur = 0; cur <= total; cur++) {
                int pick = 0;

                if (cur + arr[i - 1] <= total)
                    pick = dp[i - 1][cur + arr[i - 1]];
                int notPick = dp[i - 1][cur];

                dp[i][cur] = pick + notPick;
            }
        }

        return dp[n][0];
    }

    public int f(int i, int cur, int total, int diff, int[] arr, int[][] dp) {

        if (i < 0) {
            int s1 = cur;
            int val = total - 2 * s1;

            if (val == diff)
                return 1;
            return 0;
        }

        if (dp[i][cur] != -1)
            return dp[i][cur];

        int pick = 0;

        pick = f(i - 1, cur + arr[i], total, diff, arr, dp);
        int notPick = f(i - 1, cur, total, diff, arr, dp);

        return dp[i][cur] = pick + notPick;
    }
}
