package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            adj.get(edge[0]).add(new double[] { edge[1], prob });
            adj.get(edge[1]).add(new double[] { edge[0], prob });
        }

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        maxHeap.offer(new double[] { start_node, 1 });
        double[] best = new double[n];
        best[start_node] = 1.0;

        while (!maxHeap.isEmpty()) {
            double[] node = maxHeap.poll();
            int cur = (int) node[0];
            double prob = node[1];

            if (cur == end_node)
                return prob;

            if (prob < best[cur])
                continue;

            for (double[] nei : adj.get(cur)) {
                int next = (int) nei[0];
                double nextProb = prob * nei[1];
                if (nextProb > best[next]) {
                    best[next] = nextProb;
                    maxHeap.offer(new double[] { nei[0], nextProb });
                }
            }
        }

        return (double) 0.0;
    }
}
