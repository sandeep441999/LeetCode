package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CountPaths {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int MOD = 1_000_000_007;

        for (int[] e : roads) {
            adj.get(e[0]).add(new long[] { e[1], e[2] });
            adj.get(e[1]).add(new long[] { e[0], e[2] });
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { 0, 0 });
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[node])
                continue;

            for (long[] nei : adj.get(node)) {
                int next = (int) nei[0];
                long cost2 = nei[1];
                long n_cost = cost + cost2;

                if (n_cost < dist[next]) {
                    ways[next] = ways[node];
                    dist[next] = n_cost;
                    pq.offer(new long[] { next, n_cost });
                } else if (n_cost == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
