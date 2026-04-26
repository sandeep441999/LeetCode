package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSShortestPathUnWeighted {
    public int[] shortestPath(int[][] edges, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : edges[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 } };
        BFSShortestPathUnWeighted bfsShortestPathUnWeighted = new BFSShortestPathUnWeighted();
        int[] dist = bfsShortestPathUnWeighted.shortestPath(edges, n, 0);
        System.out.println(Arrays.toString(dist));
    }
}
