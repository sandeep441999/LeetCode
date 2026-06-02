package dp;

import java.util.Arrays;

public class CoinChange {
    // int[] memo;

    public int coinChange(int[] coins, int amount) {
        // memo = new int[amount+1];
        // Arrays.fill(memo, -1);
        // int res = dfs(coins, amount, 0);
        // return res != Integer.MAX_VALUE ? res : -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int x : coins) {
                if (x <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - x]);
                }

            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // public int dfs(int[] coins, int amount, int count) {
    // if(amount < 0) return Integer.MAX_VALUE;
    // if(amount == 0) {
    // return 0;
    // }
    // if(memo[amount]!=-1) return memo[amount];
    // int min = Integer.MAX_VALUE;
    // for(int x : coins) {
    // int result = dfs(coins, amount - x, count+1);
    // if (result != Integer.MAX_VALUE) {
    // min = Math.min(min, result + 1);
    // }
    // }
    // memo[amount] = min;
    // return min;
    // }
}
