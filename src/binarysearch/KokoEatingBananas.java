package binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        // int l = 1, r = 0;
        // for (int i = 0; i < piles.length; i++) {
        // // l = Math.min(l, piles[i]);
        // r = Math.max(r, piles[i]);
        // }
        // int ans = Integer.MAX_VALUE;

        // while (l <= r) {
        // int mid = l + (r - l) / 2;
        // int res = getVal(piles, h, mid);

        // if (res == -1) {
        // l = mid + 1;
        // } else {
        // r = mid - 1;
        // ans = Math.min(ans, mid);
        // }
        // }

        // return ans;

        int l = 1, r = Integer.MIN_VALUE;

        for (int x : piles) {
            r = Math.max(r, x);
        }
        int ans = r;

        while (l <= r) {
            int cap = l + (r - l) / 2;

            if (canDo(cap, h, piles)) {
                ans = Math.min(ans, cap);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }

        return ans;

    }

    public boolean canDo(int cap, int hours, int[] piles) {
        long h = 0;

        for (int x : piles) {
            h += (x + cap - 1) / cap;
        }

        return h <= hours;
    }

    // public int getVal(int[] piles, int h, int mid) {
    // int cur = 0;
    // for (int i = 0; i < piles.length; i++) {
    // if (piles[i] / mid == 0) {
    // cur += 1;
    // } else if (piles[i] % mid > 0) {
    // cur += piles[i] / mid + 1;
    // } else {
    // cur += piles[i] / mid;
    // }
    // if (cur > h)
    // return -1;
    // }
    // return cur;
    // }
}
