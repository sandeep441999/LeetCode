package binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1, r = 0;
        for (int i = 0; i < piles.length; i++) {
            // l = Math.min(l, piles[i]);
            r = Math.max(r, piles[i]);
        }
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = getVal(piles, h, mid);

            if (res == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        return ans;

    }

    public int getVal(int[] piles, int h, int mid) {
        int cur = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] / mid == 0) {
                cur += 1;
            } else if (piles[i] % mid > 0) {
                cur += piles[i] / mid + 1;
            } else {
                cur += piles[i] / mid;
            }
            if (cur > h)
                return -1;
        }
        return cur;
    }
}
