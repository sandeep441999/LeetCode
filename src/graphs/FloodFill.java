package graphs;

import java.util.ArrayDeque;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int n = image.length, m = image[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { sr, sc });
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int val = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0], c = cur[1];

            for (int[] d : dir) {
                int row = d[0] + r;
                int col = d[1] + c;

                if (row >= 0 && col >= 0 && row < n && col < m && image[row][col] == val) {
                    q.offer(new int[] { row, col });
                    image[row][col] = color;
                }
            }

        }

        return image;
    }
}
