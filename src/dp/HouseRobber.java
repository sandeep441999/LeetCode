package dp;

public class HouseRobber {
    public int rob(int[] nums) {
        // int[] memo = new int[nums.length+1];
        // return func(0, nums, memo);
        // }

        // public int func(int i, int[] nums, int[] memo) {
        // if(i>=nums.length) {
        // return 0;
        // }
        // if(memo[i] !=0) {
        // return memo[i];
        // }
        // int p = nums[i] + func(i+2, nums, memo);
        // int s = func(i+1, nums, memo);
        // memo[i] = Math.max(p,s);
        // return memo[i];
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // if(nums.length ==2 && dp[0] > dp[1]) {
        // return dp[0];
        // } else if (nums.length ==2 && dp[0] < dp[1]) {
        // return dp[1];
        // }
        // System.out.println(dp);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
