package slidingwindow;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        // for(int i=0; i<n; i++) {
        // int prod = nums[i];
        // if(prod<k) {
        // count++;
        // } else {
        // continue;
        // }
        // for(int j=i+1; j<n; j++) {
        // if(j<n) {
        // prod = prod * nums[j];
        // if(prod<k) {
        // count++;
        // } else {
        // break;
        // }
        // }
        // }
        // }

        int l = 0;
        int prod = 1;
        if (k <= 1)
            return 0;
        for (int r = 0; r < n; r++) {
            prod *= nums[r];

            while (l < n && prod >= k) {
                prod /= nums[l++];
            }

            count += r - l + 1;
        }
        return count;
    }
}
