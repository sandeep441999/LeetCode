package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : times) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[k] = 0;
        pq.offer(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int wt = cur[1];

            if (wt > dist[node])
                continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int wt2 = nei[1];

                if (dist[node] + wt2 < dist[next]) {
                    dist[next] = dist[node] + wt2;
                    pq.offer(new int[] { next, dist[next] });
                }
            }
        }

        int res = 0;

        for (int i = 1; i < n + 1; i++) {
            res = Math.max(res, dist[i]);
        }

        return res != Integer.MAX_VALUE ? res : -1;

    }
}
