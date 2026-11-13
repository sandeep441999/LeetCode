package graphs;

import java.util.ArrayDeque;
import java.util.List;

class DisJointSetUnion {
    int[] parent;
    int[] size;
    int n;

    public DisJointSetUnion(int n) {
        this.n = n;
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb)
            return false;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }

        return true;
    }
}

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        DisJointSetUnion ds = new DisJointSetUnion(edges.length);
        for (int[] edge : edges) {
            if (!ds.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
        // List<List<Integer>> adj = new ArrayList<>();
        // int n = edges.length;
        // for(int i=0; i<=n; i++) {
        // adj.add(new ArrayList<>());
        // }

        // for(int[] e : edges) {
        // if(hasPath(e[0], e[1], adj, n)) return e;
        // adj.get(e[0]).add(e[1]);
        // adj.get(e[1]).add(e[0]);
        // }
        // return new int[2];
    }

    public boolean hasPath(int src, int dest, List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { src, -1 });
        visited[src] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == dest)
                return true;
            for (int nei : adj.get(node[0])) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(new int[] { nei, node[0] });
                }
            }
        }

        return false;
    }
}
