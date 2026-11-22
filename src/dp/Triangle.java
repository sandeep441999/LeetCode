package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++) {
        // Arrays.fill(dp[i], (int) 1e5);
        // }
        // return f(0, 0, triangle, dp);

        // int[][] dp = new int[m][n];
        // for(int j = 0; j<n; j++) {
        // dp[m-1][j] = triangle.get(m-1).get(j);
        // }

        int[] next = new int[n];
        for (int j = 0; j < n; j++) {
            next[j] = triangle.get(m - 1).get(j);
        }

        for (int i = m - 2; i >= 0; i--) {
            int len = triangle.get(i).size();
            int[] cur = new int[len];
            // for(int j=len-1; j>=0; j--) {
            // dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            // }
            for (int j = len - 1; j >= 0; j--) {
                cur[j] = triangle.get(i).get(j) + Math.min(next[j], next[j + 1]);
            }
            next = cur;
        }

        // return dp[0][0];
        return next[0];
    }

    public int f(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int m = triangle.size();
        if (i == m - 1)
            return triangle.get(i).get(j);

        if (dp[i][j] != (int) 1e5)
            return dp[i][j];

        int cost = triangle.get(i).get(j) + Math.min(f(i + 1, j, triangle, dp), f(i + 1, j + 1, triangle, dp));

        return dp[i][j] = cost;
    }
}
