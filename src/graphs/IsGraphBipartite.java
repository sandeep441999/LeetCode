package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, color, i))
                    return false;
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int[] color, int start) {
        color[start] = 1;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph[node]) {
                if (color[nei] == -1) {
                    color[nei] = 1 - color[node];
                    q.offer(nei);
                } else {
                    if (color[nei] == color[node])
                        return false;
                }
            }
        }
        return true;
    }
}
