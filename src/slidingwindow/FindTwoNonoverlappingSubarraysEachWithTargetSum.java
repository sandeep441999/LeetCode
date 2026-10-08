package slidingwindow;

import java.util.Arrays;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        if (n == 1)
            return -1;
        int l = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (r > 0) {
                best[r] = best[r - 1];
            }
            if (sum == target) {
                int len = r - l + 1;
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[l - 1] + len);
                }
                best[r] = Math.min(best[r], len);
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
