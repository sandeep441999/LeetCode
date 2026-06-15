package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : flights) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[] { src, 0, 0 });

        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int node = cur[0];
            int stops = cur[1];
            int fare = cur[2];

            if (node == dst) {
                return fare;
            }

            if (stops > k || stops > stopsArr[node])
                continue;
            stopsArr[node] = stops;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int extra = nei[1];
                pq.offer(new int[] { next, stops + 1, fare + extra });
            }
        }

        return -1;
    }
}
