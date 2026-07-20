package dp;

public class RegularExpressionMatching {
    enum Result {
        TRUE, FALSE
    }

    Result[][] cache;

    public boolean isMatch(String s, String p) {
        cache = new Result[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, cache);
    }

    public boolean dfs(String s, String p, int i, int j, Result[][] cache) {
        if (cache[i][j] != null)
            return cache[i][j] == Result.TRUE;
        boolean ans;

        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean match = i < s.length() && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.');

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = dfs(s, p, i, j + 2, cache) || (match && dfs(s, p, i + 1, j, cache));

            } else {
                ans = match && dfs(s, p, i + 1, j + 1, cache);
            }

        }
        cache[i][j] = ans ? Result.TRUE : Result.FALSE;

        return ans;
    }
}
