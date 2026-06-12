package UnionFindDSU;

import java.util.Arrays;

public class NoOfConnectedComponentsInUndirectedGraph {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int count = n;

        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                count--;
            }
        }

        return count;

    }

    public int find(int a) {
        int x = a;
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb)
            return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
            rank[pb] += rank[pa];
        } else {
            parent[pb] = pa;
            rank[pa] += rank[pb];
        }
        return true;
    }
}
