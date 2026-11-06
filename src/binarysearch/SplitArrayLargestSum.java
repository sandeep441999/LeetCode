package binarysearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for (int x : nums) {
            l = Math.max(l, x);
            r += x;
        }
        int ans = r;

        while (l <= r) {
            int sum = l + (r - l) / 2;
            int count = 1, curSum = 0;
            for (int x : nums) {
                if (curSum + x <= sum) {
                    curSum += x;
                } else {
                    count++;
                    curSum = x;
                }

            }
            if (count <= k) {
                ans = sum;
                r = sum - 1;
            } else {
                l = sum + 1;
            }

        }
        return ans;
    }
}
