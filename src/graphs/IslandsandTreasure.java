package graphs;

import java.util.ArrayDeque;

public class IslandsandTreasure {
    public void islandsAndTreasure(int[][] grid) {

        // for(int i=0; i<grid.length; i++) {
        // for(int j=0; j<grid[0].length; j++) {
        // if(grid[i][j] == Integer.MAX_VALUE) {
        // ArrayDeque<int[]> q = new ArrayDeque<>();
        // boolean[][] visited = new boolean[grid.length][grid[0].length];
        // q.offer(new int[]{i, j, 0});
        // visited[i][j] = true;
        // grid[i][j] = bfs(grid, q, visited);
        // }
        // }
        // }

        // Above Solution gets the TLE, So I am writing the multi-source BFS and also
        // the reverse thinking intuition

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] { i, j, 0 });
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();

                int r = node[0], c = node[1], steps = node[2];

                int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

                for (int[] d : dir) {
                    int row = r + d[0];
                    int col = c + d[1];

                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length
                            && grid[row][col] == Integer.MAX_VALUE) {
                        grid[row][col] = steps + 1;
                        q.offer(new int[] { row, col, steps + 1 });
                    }
                }
            }
        }

    }

    // public int bfs(int[][] grid, ArrayDeque<int[]> q, boolean[][] visited) {
    // int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    // while(!q.isEmpty()) {
    // int[] node = q.poll();
    // if(grid[node[0]][node[1]] == 0) {
    // return node[2];
    // }
    // for(int[] d : dir) {
    // int row = node[0] + d[0];
    // int col = node[1] + d[1];
    // int steps = node[2];
    // if(row>=0 && col >= 0 && row<grid.length && col < grid[0].length &&
    // grid[row][col] != -1) {
    // if(!visited[row][col]) {
    // visited[row][col] = true;
    // q.offer(new int[]{row, col, steps+1});
    // }
    // }
    // }
    // }

    // return Integer.MAX_VALUE;

    // }
}
