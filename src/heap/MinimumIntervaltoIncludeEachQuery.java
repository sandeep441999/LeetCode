package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumIntervaltoIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];
        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;

        for (int[] x : q) {
            int val = x[0];

            while (i < intervals.length && intervals[i][0] <= val) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[] { len, intervals[i][1] });
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }
            res[x[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;
    }
}
