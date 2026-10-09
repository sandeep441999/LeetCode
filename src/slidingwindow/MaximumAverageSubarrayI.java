package slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxi = Double.MIN_VALUE;

        int l = 0, r = 0;
        double total = 0;
        while (r < k) {
            total += nums[r];
            r++;
        }
        maxi = total / k;
        while (l <= r && r < n) {
            total -= nums[l++];
            total += nums[r++];
            maxi = Math.max(maxi, total / k);
        }

        return maxi;
    }
}
