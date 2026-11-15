package graphs;

import java.util.ArrayDeque;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = 'T';
                    // bfs(i, j, board);
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    public void dfs(int i, int j, char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dir) {
            int r = d[0] + i;
            int c = d[1] + j;

            if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'O') {
                board[r][c] = 'T';
                dfs(r, c, board);
            }
        }
    }

    public void bfs(int i, int j, char[][] board) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        board[i][j] = 'T';

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int[] d : dir) {
                int row = node[0] + d[0];
                int col = node[1] + d[1];

                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && (board[row][col] == 'O')) {
                    board[row][col] = 'T';
                    q.offer(new int[] { row, col });
                }
            }
        }
        return;
    }
}
