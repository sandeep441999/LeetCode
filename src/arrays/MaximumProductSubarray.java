package arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            min = Math.min(tmp * nums[i], Math.min(nums[i], min * nums[i]));
            ans = Math.max(ans, max);
            System.out.println("ans " + ans);
        }
        return ans;
    }
}
