package dp;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[n];
        // Arrays.fill(dp1, -1);
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        dp1[0] = nums1[0];
        dp1[1] = Math.max(nums1[0], nums1[1]);
        int[] dp2 = new int[n];
        // Arrays.fill(dp2, -1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);
        dp2[0] = nums2[0];
        dp2[1] = Math.max(nums2[0], nums2[1]);

        // return Math.max(f
        // (n-2, Arrays.copyOfRange(nums, 0, n-1), dp1), f(n-2, Arrays.copyOfRange(nums,
        // 1, n), dp2));

        for (int i = 2; i < n - 1; i++) {
            int steal = nums1[i] + dp1[i - 2];
            int notSteal = 0 + dp1[i - 1];
            dp1[i] = Math.max(steal, notSteal);
        }

        for (int i = 2; i < n - 1; i++) {
            int steal = nums2[i] + dp2[i - 2];
            int notSteal = 0 + dp2[i - 1];
            dp2[i] = Math.max(steal, notSteal);
        }

        return Math.max(dp1[n - 2], dp2[n - 2]);
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