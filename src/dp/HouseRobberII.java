package dp;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(func(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                func(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int func(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = 0;
        boolean fl = false;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
