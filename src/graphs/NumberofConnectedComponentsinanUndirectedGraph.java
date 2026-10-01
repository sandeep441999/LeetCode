package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph {
    // int[] parent;
    // int[] rank;
    public int countComponents(int n, int[][] edges) {
        // parent = new int[n];
        // rank = new int[n];
        // int count = n;

        // Arrays.fill(rank, 1);
        // for(int i=0; i<n; i++) {
        // parent[i] = i;
        // }

        // for(int[] e : edges) {
        // if(union(e[0], e[1])) {
        // count--;
        // }
        // }
        // return count;

        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(adj, visited, nei);
            }
        }
    }

    // public int find(int a) {
    // int x = a;
    // while(parent[x] != x) {
    // parent[x] = parent[parent[x]];
    // x = parent[x];
    // }
    // return x;
    // }

    // public boolean union(int a, int b) {
    // int pa = find(a), pb = find(b);
    // if(pa == pb) return false;

    // if(rank[pa]<rank[pb]) {
    // parent[pa] = pb;
    // rank[pb] += rank[pa];
    // } else {
    // parent[pb] = pa;
    // rank[pa] += rank[pb];
    // }
    // return true;
    // }
}
