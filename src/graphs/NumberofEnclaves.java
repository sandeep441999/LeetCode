package graphs;

import java.util.ArrayDeque;

class DisJointUnionSet {
    int[] parent;
    int[] size;

    public DisJointUnionSet(int n) {
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

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb)
            return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}

public class NumberofEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int boundary = m * n;
        DisJointUnionSet dsu = new DisJointUnionSet(boundary);
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1)
                    continue;
                int id = i * n + j;
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dsu.union(id, boundary);
                }

                for (int[] d : dir) {
                    int r = d[0] + i;
                    int c = d[1] + j;

                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        dsu.union(id, r * n + c);
                    }
                }

            }
        }

        // for(int i=0; i<m; i++) {
        // for(int j=0; j<n; j++) {
        // if((i==0 || i == m-1 || j ==0 || j==n-1) && grid[i][j] == 1) {
        // grid[i][j] = 2;
        // bfs(i, j, grid);
        // }
        // }
        // }
        int res = 0;

        // for(int i=0; i<m; i++) {
        // for(int j=0; j<n; j++) {
        // if(grid[i][j] == 1) {
        // res++;
        // }
        // }
        // }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int id = i * n + j;
                    if (dsu.find(id) != dsu.find(boundary)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public void bfs(int row, int col, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { row, col });

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int[] d : dir) {
                int r = d[0] + node[0];
                int c = d[1] + node[1];

                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    q.offer(new int[] { r, c });
                }
            }
        }
    }
}
