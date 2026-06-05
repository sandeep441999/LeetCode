package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> res = new ArrayList<>();

    int rows = 0, cols = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        // for(int i=0; i<cols; i++) {
        // dfs(0, i, pac, heights, heights[0][i]);
        // }
        // for(int i=0; i<cols; i++) {
        // dfs(rows-1, i, atl, heights, heights[rows-1][i]);
        // }
        // for(int i=0; i<rows; i++) {
        // dfs(i, 0, pac, heights, heights[i][0]);
        // }
        // for(int i=0; i<rows; i++) {
        // dfs(i, cols-1, atl, heights, heights[i][cols-1]);
        // }
        Queue<int[]> pacq = new ArrayDeque<>();
        Queue<int[]> atlq = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            pacq.offer(new int[] { i, 0 });
            atlq.offer(new int[] { i, cols - 1 });
            pac[i][0] = true;
            atl[i][cols - 1] = true;
        }
        for (int i = 0; i < cols; i++) {
            pacq.offer(new int[] { 0, i });
            atlq.offer(new int[] { rows - 1, i });
            pac[0][i] = true;
            atl[rows - 1][i] = true;
        }
        bfs(pacq, pac, heights);
        bfs(atlq, atl, heights);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    // public void dfs(int r, int c, boolean[][] visited, int[][] heights, int
    // prevHeight) {
    // if(r<0 || c<0 || r==rows || c == cols || heights[r][c] < prevHeight ||
    // visited[r][c]) return;

    // visited[r][c] = true;

    // dfs(r+1, c, visited, heights, heights[r][c]);
    // dfs(r-1, c, visited, heights, heights[r][c]);
    // dfs(r, c+1, visited, heights, heights[r][c]);
    // dfs(r, c-1, visited, heights, heights[r][c]);

    // }

    public void bfs(Queue<int[]> q, boolean[][] visited, int[][] heights) {
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int row = val[0];
            int col = val[1];
            for (int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || c < 0 || r == rows || c == cols)
                    continue;
                if (visited[r][c])
                    continue;
                if (heights[r][c] < heights[row][col])
                    continue;
                visited[r][c] = true;
                q.offer(new int[] { r, c });
            }
        }
    }
}
