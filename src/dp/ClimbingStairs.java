package dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        // return f(n, dp);

        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int prev1 = 0, prev2 = 1, cur = 0;
        for (int i = 1; i <= n; i++) {

            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }

        return prev2;

        // return dp[n+1];
    }

    public int f(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }
}
