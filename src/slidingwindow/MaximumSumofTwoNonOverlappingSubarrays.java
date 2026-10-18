package slidingwindow;

public class MaximumSumofTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans1 = solve(nums, firstLen, secondLen);
        int ans2 = solve(nums, secondLen, firstLen);

        return Math.max(ans1, ans2);
    }

    public int solve(int[] nums, int firstLen, int secondLen) {
        int l = 0, r = 0, n = nums.length, sum = 0;
        int[] best = new int[n];

        while (r < n) {
            sum += nums[r];
            if (r - l + 1 > firstLen) {
                sum -= nums[l++];
            }

            if (r > 0)
                best[r] = best[r - 1];

            if (r - l + 1 == firstLen) {
                best[r] = Math.max(best[r], sum);
            }
            r++;
        }

        l = 0;
        sum = 0;
        int ans = 0;
        r = 0;

        while (r < n) {
            sum += nums[r];
            if (r - l + 1 > secondLen) {
                sum -= nums[l++];
            }

            if (r - l + 1 == secondLen && l >= firstLen) {
                ans = Math.max(ans, best[l - 1] + sum);
            }
            r++;
        }

        return ans;
    }
}
