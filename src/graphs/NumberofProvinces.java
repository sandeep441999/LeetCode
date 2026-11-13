package graphs;

import java.util.ArrayDeque;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        // int count = 0;
        // boolean[] visited = new boolean[isConnected.length];
        // for(int i=0; i<isConnected.length; i++) {
        // if(!visited[i]) {
        // count++;
        // dfs(isConnected, i, visited);
        // }
        // }
        // return count;
        int n = isConnected.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[n];

        int count = 0;
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                count++;
                q.offer(j);
                visited[j] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int i = 0; i < n; i++) {
                        if (isConnected[node][i] == 1 && !visited[i]) {
                            visited[i] = true;
                            q.offer(i);
                        }
                    }

                }
            }

        }
        return count;

    }

    public void dfs(int[][] isConnected, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }
}
