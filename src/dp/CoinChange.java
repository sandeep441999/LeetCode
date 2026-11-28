package dp;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // int res = f(n-1, amount, coins, dp);

        int[][] dp = new int[n + 1][amount + 1];
        for (int a = 0; a <= amount; a++) {
            dp[0][a] = (int) 1e8;
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int a = 0; a <= amount; a++) {
                int pick = (int) 1e8;
                if (a - coins[i - 1] >= 0) {
                    pick = 1 + dp[i][a - coins[i - 1]];
                }

                int notPick = dp[i - 1][a];

                dp[i][a] = Math.min(pick, notPick);
            }
        }

        return dp[n][amount] >= (int) 1e8 ? -1 : dp[n][amount];

        // return res >= (int) 1e8 ? -1 : res;
    }

    public int f(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0)
            return 0;
        if (i < 0) {
            return (int) 1e8;
        }

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int pick = (int) 1e8;
        if (amount - coins[i] >= 0) {
            pick = 1 + f(i, amount - coins[i], coins, dp);
        }

        int notPick = f(i - 1, amount, coins, dp);

        return dp[i][amount] = Math.min(pick, notPick);
    }
}
