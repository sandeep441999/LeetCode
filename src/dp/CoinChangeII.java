package dp;

public class CoinChangeII {
    // Integer[][] memo;
    public int change(int amount, int[] coins) {
        // memo = new Integer[coins.length][amount];
        // return backtrack(amount, coins, 0, 0);

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
    }

    // public int backtrack(int amount, int[] coins, int total, int idx) {
    // if(total == amount) return 1;
    // if(total > amount || idx==coins.length) return 0;

    // if(memo[idx][total] != null) {
    // return memo[idx][total];
    // }

    // memo[idx][total] = backtrack(amount, coins, total + coins[idx], idx) +
    // backtrack(amount, coins, total, idx+1);

    // return memo[idx][total];
    // }
}
