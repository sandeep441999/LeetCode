package minimumspanningtree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCosttoConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[] { dist, j });
                adj.get(j).add(new int[] { dist, i });
            }
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] { 0, 0 });
        int minCost = 0;
        int used = 0;

        while (used < n) {
            int[] point = pq.poll();

            int dist = point[0];
            int start = point[1];

            if (visited[start])
                continue;

            visited[start] = true;
            minCost += dist;
            used++;

            for (int[] nei : adj.get(start)) {
                int neiDist = nei[0];
                int neiNode = nei[1];

                if (!visited[neiNode]) {
                    pq.offer(new int[] { neiDist, neiNode });

                }
            }
        }

        return minCost;
    }
}
