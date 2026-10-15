package slidingwindow;

import java.util.Arrays;

public class MinimumOperationstoReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        // int total = 0, n = nums.length;
        // for(int num : nums) {
        // total+=num;
        // }
        // int target = total - x;
        // if(target < 0) return -1;
        // int l = 0, r=0;
        // int sum = 0;
        // int len = Integer.MIN_VALUE;

        // while(r<n) {
        // sum+=nums[r];
        // while(sum > target) {
        // sum-=nums[l];
        // l++;
        // }
        // if(sum == target) {
        // len = Math.max(len, r-l+1);
        // }
        // r++;
        // }

        // return len == Integer.MIN_VALUE ? -1 : n-len;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(nums, 0, n - 1, x, dp);
        return ans >= 100000 ? -1 : ans;
    }

    public int f(int[] nums, int l, int r, int x, int[][] dp) {

        if (x == 0)
            return 0;

        if (x < 0 || l > r)
            return (int) 1e7;

        if (dp[l][r] != -1)
            return dp[l][r];
        int left = 100000;
        if (nums[l] <= x) {
            left = 1 + f(nums, l + 1, r, x - nums[l], dp);
        }
        int right = 100000;
        if (nums[r] <= x) {
            right = 1 + f(nums, l, r - 1, x - nums[r], dp);
        }

        return dp[l][r] = Math.min(left, right);
    }
}
