package binarysearch;

public class MinimumLimitofBallsinaBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int x : nums) {
            r = Math.max(x, r);
        }
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canDo(nums, maxOperations, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean canDo(int[] nums, int maxOperations, int max_balls) {
        int operations = 0;
        for (int x : nums) {
            operations += (int) Math.ceil((double) x / max_balls) - 1;
            if (operations > maxOperations)
                return false;
        }
        return true;
    }
}
