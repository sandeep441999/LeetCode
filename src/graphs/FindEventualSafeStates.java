package graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] samePath = new boolean[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(graph, i, samePath, visited, check);
        }

        for (int i = 0; i < n; i++) {
            if (check[i])
                res.add(i);
        }

        return res;
    }

    public boolean dfs(int[][] graph, int start, boolean[] samePath, boolean[] visited, boolean[] check) {
        visited[start] = true;
        samePath[start] = true;

        for (int nei : graph[start]) {
            if (!visited[nei]) {
                if (dfs(graph, nei, samePath, visited, check)) {
                    return true;
                }
            } else {
                if (samePath[nei])
                    return true;
            }
        }
        check[start] = true;
        samePath[start] = false;
        return false;
    }
}
