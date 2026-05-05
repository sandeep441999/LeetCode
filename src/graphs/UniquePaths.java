package graphs;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Map<String, Integer> map = new HashMap<>();
        // return dfs(0, 0, m-1, n-1, map);
        // int[][] dp = new int[m][n];

        // for(int i =0; i<m; i++) {
        // dp[i][n-1] = 1;
        // }
        // for(int j =0; j<n; j++) {
        // dp[m-1][j] = 1;
        // }

        // for(int i = m-2; i>=0; i--) {
        // for(int j = n-2; j>=0; j--) {
        // dp[i][j] = dp[i][j+1] + dp[i+1][j];
        // }
        // }
        // return dp[0][0];

        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1);

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }

    // public int dfs(int m, int n, int tm, int tn, Map<String, Integer> map) {
    // if(m== tm && n == tn) {
    // return 1;
    // }
    // if(m>tm || n >tn) {
    // return 0;
    // }
    // String Key = m + "," + n;
    // if(map.containsKey(Key)) {
    // return map.get(Key);
    // }
    // int ways = dfs(m+1, n, tm, tn, map) + dfs(m, n+1, tm, tn, map);
    // map.put(Key, ways);
    // return ways;
    // }
}
