package trees;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    // int[] parent;
    // int[] rank;
    public boolean validTree(int n, int[][] edges) {
        // parent = new int[n];
        // rank = new int[n];
        // int res = n;
        // Arrays.fill(rank, 1);
        // for(int i=0; i<n; i++) {
        // parent[i] = i;
        // }
        // for(int[] e : edges) {
        // if(union(e[0], e[1])) {
        // res--;
        // } else {
        // return false;
        // }
        // }
        // return res == 1 ? true : false;

        if (edges.length != n - 1)
            return false;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                count++;
            }
        }

        return count == 1 ? true : false;
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
    // if(rank[pa] < rank[pb]) {
    // parent[pa] = pb;
    // rank[pb] += rank[pa];
    // } else {
    // parent[pb] = pa;
    // rank[pa] += rank[pb];
    // }
    // return true;
    // }
}
