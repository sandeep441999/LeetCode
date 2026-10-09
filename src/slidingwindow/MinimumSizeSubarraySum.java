package slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        // int l=0, r=0;
        int l = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        // while(r<n) {
        // sum+=nums[r];

        // if(sum>=target) {
        // int len = r-l+1;
        // ans = Math.min(ans, len);
        // while(sum>=target) {
        // sum-=nums[l++];
        // if(sum>=target) {
        // ans = Math.min(ans, r-l+1);
        // }
        // }
        // }
        // r++;
        // }

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
