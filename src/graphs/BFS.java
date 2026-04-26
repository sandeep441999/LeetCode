package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + " ");

            for (int neighbor : edges[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 } };
        BFS bfs = new BFS();
        bfs.bfs(edges, n);
    }

}