package binarysearch;

public class MinimumTimetoCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long l = Integer.MAX_VALUE, r = 0;
        for (int x : time) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }
        r = l * totalTrips;
        long ans = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (canDo(time, totalTrips, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;

    }

    public boolean canDo(int[] time, int totalTrips, long t) {
        long trips = 0;

        for (int x : time) {
            trips += t / x;
        }

        return trips >= totalTrips;
    }
}
