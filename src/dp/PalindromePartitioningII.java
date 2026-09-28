package dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
        // int[] dp = new int[s.length()];
        // Arrays.fill(dp, -1);
        // return f(0, s, dp)-1;

        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int min_cost = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    min_cost = Math.min(min_cost, cost);
                }
            }
            dp[i] = min_cost;
        }

        return dp[0] - 1;
    }

    // public int f(int idx, String s, int[] dp) {
    // if(idx == s.length()) return 0;
    // int min_cost = Integer.MAX_VALUE;

    // if(dp[idx] != -1) return dp[idx];

    // for(int i=idx; i<s.length(); i++) {
    // if(isPalindrome(idx, i, s)) {
    // int cost = 1+f(i+1,s, dp);
    // min_cost = Math.min(min_cost, cost);
    // }
    // }

    // return dp[idx]=min_cost;
    // }

    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
