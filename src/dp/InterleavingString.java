package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length())
            return false;

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(0, 0, s1, s2, s3, memo);
    }

    public boolean dfs(int l, int r, String s1, String s2, String s3, Boolean[][] memo) {
        if (l == s1.length() && r == s2.length())
            return true;

        if (memo[l][r] != null)
            return memo[l][r];

        int idx = l + r;
        boolean res = false;

        if (l < s1.length() && s3.charAt(idx) == s1.charAt(l)) {
            res = dfs(l + 1, r, s1, s2, s3, memo);
        }
        if (!res && r < s2.length() && s3.charAt(idx) == s2.charAt(r)) {
            return dfs(l, r + 1, s1, s2, s3, memo);
        }

        return memo[l][r] = res;

    }
}
