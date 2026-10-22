package binarysearch;

public class Sqrtx {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        long square = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            square = (long) mid * mid;
            if (square <= x) {
                // ans = Math.max(ans, mid);
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
