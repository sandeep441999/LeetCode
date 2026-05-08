package backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] f = new char[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[board[i][j]]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--f[c] < 0) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int idx, char[][] board, String word, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (idx == word.length())
            return true;
        if (i < 0 || i >= m ||
                j < 0 || j >= n ||
                board[i][j] == '#' ||
                board[i][j] != word.charAt(idx)) {

            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(idx + 1, board, word, i + 1, j) ||
                dfs(idx + 1, board, word, i - 1, j) ||
                dfs(idx + 1, board, word, i, j + 1) ||
                dfs(idx + 1, board, word, i, j - 1);

        board[i][j] = temp;
        return found;
    }
}
