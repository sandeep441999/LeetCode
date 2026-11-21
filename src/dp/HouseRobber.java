package dp;

public class HouseRobber {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // Arrays.fill(dp, -1);
        // return f(n-1, nums, dp);

        for (int i = 2; i < n; i++) {
            int steal = nums[i] + dp[i - 2];
            int notSteal = 0 + dp[i - 1];
            dp[i] = Math.max(steal, notSteal);
        }
        return dp[n - 1];
    }

    public int f(int i, int[] nums, int[] dp) {

        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int steal = nums[i] + f(i - 2, nums, dp);
        int notSteal = 0 + f(i - 1, nums, dp);

        return dp[i] = Math.max(steal, notSteal);
    }

}
