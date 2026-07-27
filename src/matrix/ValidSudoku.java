package matrix;

import java.util.HashSet;

public class ValidSudoku {
    // Map<Integer, int[]> map;
    public boolean isValidSudoku(char[][] board) {
        // map = new HashMap<>();
        // map.put(0, new int[]{0,3});
        // map.put(1, new int[]{0,3});
        // map.put(2, new int[]{0,3});
        // map.put(3, new int[]{3, 6});
        // map.put(4, new int[]{3, 6});
        // map.put(5, new int[]{3, 6});
        // map.put(6, new int[]{6, 9});
        // map.put(7, new int[]{6, 9});
        // map.put(8, new int[]{6, 9});

        // for(int i=0; i<9; i++) {
        // for(int j=0; j<9; j++) {
        // if(board[i][j] != '.') {
        // if(!(isValidRow(board, i, j) && isValidCol(board, i, j) &&
        // isValidBoard(board, i, j))) return false;
        // }
        // }
        // }
        // return true;

        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                String r = board[i][j] + " in row " + i;
                String c = board[i][j] + " in col " + j;
                String b = board[i][j] + " in box " + (i / 3) + "-" + (j / 3);

                if (!visited.add(r) || !visited.add(c) || !visited.add(b))
                    return false;
            }
        }

        return true;
    }

    public boolean isValidRow(char[][] board, int i, int j) {
        int count = 0;
        char c = board[i][j];
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c)
                count += 1;
            if (count >= 2)
                return false;
        }
        return true;
    }

    public boolean isValidCol(char[][] board, int i, int j) {
        int count = 0;
        char c = board[i][j];
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c)
                count += 1;
            if (count >= 2)
                return false;
        }
        return true;
    }

    public boolean isValidBoard(char[][] board, int i, int j) {
        int count = 0;
        char ch = board[i][j];
        // int rl = map.get(i)[0];
        // int rr = map.get(i)[1];
        // int cl = map.get(j)[0];
        // int cr = map.get(j)[1];

        int rl = (i / 3) * 3;
        int cl = (j / 3) * 3;
        for (int r = rl; r < rl + 3; r++) {
            for (int c = cl; c < cl + 3; c++) {
                if (board[r][c] == ch)
                    count += 1;
                if (count >= 2)
                    return false;
            }

        }
        return true;
    }
}
