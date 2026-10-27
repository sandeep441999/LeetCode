package binarysearch;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, total = 0;
        for (int x : weights) {
            max = Math.max(max, x);
            total += x;
        }

        int l = max, r = total;
        int ans = total;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canDo(mid, days, weights)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean canDo(int cap, int days, int[] weights) {
        int curCap = cap, day = 1;

        for (int x : weights) {
            if (curCap - x < 0) {
                day++;
                curCap = cap;
            }

            curCap -= x;
        }

        return day <= days;
    }
}
