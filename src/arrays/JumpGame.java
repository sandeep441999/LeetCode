package arrays;

public class JumpGame {

    public boolean canJump(int[] nums) {
        // if(nums.length <= 1) {
        // return true;
        // }

        // if(nums[0] == 0) {
        // return false;
        // }

        // int[] dp = new int[nums.length];
        // int max = nums[0];
        // dp[0] = max;

        // for(int i=1; i<nums.length; i++) {
        // dp[i] = Math.max(dp[i-1], nums[i] + i);
        // if(dp[i] >= nums.length-1) {
        // return true;
        // }
        // if(dp[i] == i) {
        // return false;
        // }
        // }

        // return dp[nums.length-1] >= nums.length;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max)
                return false;

            max = Math.max(max, nums[i] + i);

            if (max >= nums.length - 1)
                return true;
        }
        return false;
    }

}
