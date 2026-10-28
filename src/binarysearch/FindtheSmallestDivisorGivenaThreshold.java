package binarysearch;

public class FindtheSmallestDivisorGivenaThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1;
        for (int x : nums) {
            r = Math.max(r, x);
        }
        int ans = r;

        while (l <= r) {
            int d = l + (r - l) / 2;
            int sum = 0;
            for (int x : nums) {
                sum += (x + d - 1) / d;
            }

            if (sum <= threshold) {
                ans = Math.min(ans, d);
            }

            if (sum > threshold) {
                l = d + 1;
            } else {
                r = d - 1;
            }
        }
        return ans;
    }
}
