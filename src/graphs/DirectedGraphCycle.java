package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DirectedGraphCycle {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        // boolean[] visited = new boolean[n];
        // boolean[] samePath = new boolean[n];
        // for(int i=0; i<n; i++) {
        // if(!visited[i]) {

        // if(dfs(adj, visited, samePath, i)) return true;
        // }
        // }

        // return false;

        int[] indegree = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int x : adj.get(i)) {
                indegree[x]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int visited = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return visited != n;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] samePath, int start) {
        visited[start] = true;
        samePath[start] = true;

        for (int nei : adj.get(start)) {
            if (!visited[nei]) {
                if (dfs(adj, visited, samePath, nei))
                    return true;
            } else {
                if (samePath[nei])
                    return true;
            }
        }

        samePath[start] = false;
        return false;
    }
}
