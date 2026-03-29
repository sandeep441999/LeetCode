package arrays;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // int[] dp = new int[nums.length];
        int sum = nums[0];
        int curr = sum;
        // dp[0] = sum;

        // for(int i=1; i<nums.length; i++) {
        // dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        // sum = Math.max(sum, dp[i]);
        // }

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            sum = Math.max(sum, curr);
        }
        return sum;
    }

}
