package dp;

public class DecodeWays {
    Integer[] dp;

    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return dfs(0, s);
    }

    public int dfs(int idx, String s) {
        if (idx == s.length())
            return 1;
        if (dp[idx] != null) {
            return dp[idx];
        }
        if (s.charAt(idx) == '0')
            return 0;

        int ways = dfs(idx + 1, s);

        if (idx + 1 < s.length()) {
            int val = ((s.charAt(idx) - '0') * 10) + (s.charAt(idx + 1) - '0');
            if (val >= 10 && val <= 26) {
                ways += dfs(idx + 2, s);
            }
        }
        dp[idx] = ways;
        return ways;
    }
}
