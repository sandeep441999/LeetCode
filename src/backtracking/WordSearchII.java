package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        // for(int w=0; w<words.length; w++) {
        // int[] f = new int[128];
        // for(int i=0; i<m; i++) {
        // for(int j=0; j<n; j++) {
        // f[board[i][j]]++;
        // }
        // }
        // for(char c: words[w].toCharArray()) {
        // if(--f[c] < 0) continue;
        // }

        // boolean found = false;
        boolean[][] visited = new boolean[m][n];
        // found = callDFS(board, words[w], m, n, visited);
        // if(found) {
        // res.add(words[w]);
        // }
        // }
        // return res;
        TrieNode root = new TrieNode();
        for (String w : words) {
            root.addWord(w);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", root, i, j, visited);
            }
        }

        return res;

    }

    public void dfs(char[][] board, String word, TrieNode node, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return;

        char c = board[i][j];

        if (!node.children.containsKey(c)) {
            return;
        }

        node = node.children.get(board[i][j]);
        word += c;

        if (node.isWord) {
            res.add(word);
            node.isWord = false;
        }
        visited[i][j] = true;
        dfs(board, word, node, i + 1, j, visited);
        dfs(board, word, node, i - 1, j, visited);
        dfs(board, word, node, i, j + 1, visited);
        dfs(board, word, node, i, j - 1, visited);
        visited[i][j] = false;
    }

    // public boolean callDFS(char[][] board, String word, int m, int n, boolean[][]
    // visited) {
    // for(int i=0; i<m; i++) {
    // for(int j=0; j<n; j++) {
    // if(dfs(0, board, word, i, j, visited)) return true;
    // }
    // }
    // return false;
    // }

    // public boolean dfs(int idx, char[][] board, String word, int i, int j,
    // boolean[][] visited) {
    // int m=board.length, n=board[0].length;
    // if(idx == word.length()) {
    // return true;
    // }

    // if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j] !=
    // word.charAt(idx)) return false;

    // visited[i][j] = true;
    // boolean found2 = dfs(idx+1, board, word, i+1, j, visited) ||
    // dfs(idx+1, board, word, i-1, j, visited) ||
    // dfs(idx+1, board, word, i, j+1, visited) ||
    // dfs(idx+1, board, word, i, j-1, visited);
    // visited[i][j] = false;
    // return found2;
    // }
}
