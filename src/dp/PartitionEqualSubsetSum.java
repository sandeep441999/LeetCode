package dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int Sum = 0;

        for (int i = 0; i < n; i++) {
            Sum += nums[i];
        }

        if (Sum % 2 != 0)
            return false;
        Sum = Sum / 2;

        // int[][] dp = new int[n][sum+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // return f(n-1, sum, nums, dp);

        boolean[][] dp = new boolean[n + 1][Sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= Sum; sum++) {
                boolean pick = false;
                if (nums[i - 1] <= sum) {
                    pick = dp[i - 1][sum - nums[i - 1]];
                }

                boolean notPick = dp[i - 1][sum];

                dp[i][sum] = (pick || notPick);
            }
        }

        return dp[n][Sum];
    }

    public boolean f(int i, int sum, int[] nums, int[][] dp) {
        if (sum == 0)
            return true;
        if (i < 0)
            return false;

        if (dp[i][sum] != -1)
            return dp[i][sum] == 1;

        boolean pick = false;
        if (nums[i] <= sum) {
            pick = f(i - 1, sum - nums[i], nums, dp);
        }

        boolean notPick = f(i - 1, sum, nums, dp);

        dp[i][sum] = (pick || notPick) ? 1 : 0;

        return dp[i][sum] == 1;
    }
}
