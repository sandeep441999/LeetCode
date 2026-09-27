package dp;

public class DistinctSubsequences {
    // public int f(int sIdx, int tIdx, String s, String t, int[][] memo) {
    // if(tIdx < 0) {
    // return 1;
    // }
    // if(sIdx < 0 || sIdx < tIdx) return 0;

    // if(memo[sIdx][tIdx] != -1) return memo[sIdx][tIdx];

    // int take = 0, notTake = 0;

    // if(s.charAt(sIdx) == t.charAt(tIdx)) {
    // take = f(sIdx-1,tIdx-1, s, t, memo);
    // notTake += f(sIdx-1,tIdx, s, t, memo);
    // memo[sIdx][tIdx] = take + notTake;
    // return memo[sIdx][tIdx];
    // }
    // memo[sIdx][tIdx] = f(sIdx-1, tIdx, s, t, memo);
    // return memo[sIdx][tIdx];
    // }
    public int numDistinct(String s, String t) {
        // int[][] memo = new int[s.length()][t.length()];
        // for(int x=0; x< s.length(); x++) {
        // Arrays.fill(memo[x], -1);
        // }
        // return f(s.length()-1, t.length()-1, s, t, memo);

        int n = s.length(), m = t.length();

        // int[][] dp = new int[n+1][m+1];

        // for(int i=0; i<=n; i++) {
        // dp[i][0] = 1;
        // }

        int[] prev = new int[m + 1];

        prev[0] = 1;

        int take = 0, notTake = 0;

        // for(int i=1; i<=n; i++) {
        // for(int j=1; j<=m; j++) {
        // if(s.charAt(i-1) == t.charAt(j-1)) {
        // take = dp[i-1][j-1];
        // notTake = dp[i-1][j];
        // dp[i][j] = take + notTake;
        // } else {
        // dp[i][j] = dp[i-1][j];
        // }
        // }
        // }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    take = prev[j - 1];
                    notTake = prev[j];
                    cur[j] = take + notTake;
                } else {
                    cur[j] = prev[j];
                }
            }

            prev = cur;
        }

        // return dp[n][m];
        return prev[m];

    }
}
