package UnionFindDSU;

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
            size[i] = 0;
        }
    }

    public int findParent(int x) {
        while (parent[x] != x) {
            x = findParent(parent[x]);
        }

        return parent[x] = x;
    }

    public boolean union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb)
            return false;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb]++;
        } else if (size[pa] > size[pb]) {
            parent[pb] = pa;
            size[pa]++;
        } else {
            parent[pb] = pa;
            size[pa]++;
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
    }
}
