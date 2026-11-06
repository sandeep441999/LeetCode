package binarysearch;

public class MinimumSpeedtoArriveonTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        // int l = 1, r = 0, d = 0;
        int l = 1, r = 0;
        // for (int x : dist) {
        // d += x;
        // }
        // l = Math.max(1, (int) Math.ceil((double) d / hour));

        // System.out.println(l);
        if (hour <= dist.length - 1)
            return -1;
        r = 10000000;
        int ans = -1;

        while (l <= r) {
            int speed = l + (r - l) / 2;

            if (canDo(dist, hour, speed)) {
                ans = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }

        return ans;

    }

    public boolean canDo(int[] dist, double hour, int speed) {
        double time = 0.0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
            if (time > hour)
                return false;
        }
        time += (double) dist[n - 1] / speed;
        return time <= hour;
    }
}
