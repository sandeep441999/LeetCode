package binarysearch;

public class MinimumNumberofDaystoMakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        if ((long) m * k > bloomDay.length)
            return -1;

        for (int x : bloomDay) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }
        int ans = r;

        while (l <= r) {
            int day = l + (r - l) / 2;
            int cur = 0, count = 0;
            for (int x : bloomDay) {
                if (x > day) {
                    count += cur / k;
                    cur = 0;
                    continue;
                }
                cur++;
            }
            count += cur / k;

            if (count < m) {

                l = day + 1;
            } else {
                // ans = Math.min(ans, day);
                ans = day;
                r = day - 1;
            }
        }

        return ans;
    }
}
