package greedy;

import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        if (startFuel >= target)
            return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int i = 0;

        while (startFuel < target) {

            while (i < stations.length && stations[i][0] <= startFuel) {
                pq.offer(stations[i]);
                i++;
            }

            if (pq.isEmpty())
                return -1;

            res += 1;
            startFuel += pq.poll()[1];
        }

        return res;
    }
}
