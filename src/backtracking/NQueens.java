package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> d1 = new HashSet<>();
        HashSet<Integer> d2 = new HashSet<>();
        backtrack(grid, 0, col, d1, d2);
        return res;
    }

    public void backtrack(char[][] grid, int r, HashSet<Integer> col, HashSet<Integer> d1, HashSet<Integer> d2) {
        if (r == grid.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    str.append(grid[i][j]);
                }
                ans.add(str.toString());
            }
            res.add(ans);
            return;
        }

        for (int j = 0; j < grid.length; j++) {
            if (!col.contains(j) && !d1.contains(r + j) && !d2.contains(r - j)) {
                grid[r][j] = 'Q';
                col.add(j);
                d1.add(r + j);
                d2.add(r - j);
                backtrack(grid, r + 1, col, d1, d2);
                grid[r][j] = '.';
                col.remove(j);
                d1.remove(r + j);
                d2.remove(r - j);
            }
        }
    }
}
