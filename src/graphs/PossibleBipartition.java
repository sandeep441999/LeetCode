package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : dislikes) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(adj, color, i, 1))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int start, int c) {
        color[start] = c;

        for (int nei : adj.get(start)) {
            if (color[nei] == -1) {
                if (!dfs(adj, color, nei, 1 - c))
                    return false;
            } else {
                if (color[nei] == c)
                    return false;
            }
        }

        return true;
    }
}
