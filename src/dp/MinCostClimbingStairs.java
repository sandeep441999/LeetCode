package dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 0;
        // for(int i=2; i<= n; i++) {
        // dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        // }

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int cur = Math.min(cost[i - 1] + prev1, cost[i - 2] + prev2);

            prev2 = prev1;
            prev1 = cur;
        }

        // return dp[n];
        return prev1;
    }
}
