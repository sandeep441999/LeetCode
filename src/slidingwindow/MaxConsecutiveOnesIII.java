package slidingwindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        while (r < n) {

            if (nums[r] == 1) {
                len = r - l + 1;
                r++;
            } else {
                k--;
                while (k < 0) {
                    if (nums[l] == 0) {
                        k++;
                    }
                    l++;
                }
                len = r - l + 1;
                r++;
            }

            maxi = Math.max(maxi, len);
        }

        return maxi != Integer.MIN_VALUE ? maxi : 0;
    }
}
