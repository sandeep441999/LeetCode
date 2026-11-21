package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] e : edges) {
            adj.get(e[1]).add(e[0]);
            adj.get(e[0]).add(e[1]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int rem = n;

        while (rem > 2) {
            int size = q.size();
            rem -= size;

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei : adj.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        return new ArrayList<>(q);

        // int mht = Integer.MAX_VALUE;

        // PriorityQueue<int[]> min = new PriorityQueue<>((a, b) ->
        // Integer.compare(a[1], b[1]));
        // int cur = 0;

        // for(int i=0; i<n;i++) {
        // cur = bfs(adj, n, i);
        // mht = Math.min(mht, cur);
        // min.offer(new int[]{i, cur});
        // }

        // List<Integer> res = new ArrayList<>();
        // while(!min.isEmpty()) {
        // int[] val = min.poll();
        // if(val[1] > mht) break;
        // if(val[1] == mht) {
        // res.add(val[0]);
        // }
        // }

        // return res;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj, int n, int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int height = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            height++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei : adj.get(node)) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        return height - 1;
    }
}
