package dp;

public class BestTimetoBuyandSellStockwithCooldown {
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // memo = new Integer[n][2];
        // return dfs(0, 1, prices);

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);

            dp[i][1] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]);
        }

        return dp[0][0];
    }

    public int dfs(int day, int buying, int[] prices) {
        if (day >= prices.length)
            return 0;

        if (memo[day][buying] != null)
            return memo[day][buying];

        if (buying == 1) {
            int buy = -prices[day] + dfs(day + 1, 0, prices);
            int cooldown = dfs(day + 1, 1, prices);
            memo[day][buying] = Math.max(buy, cooldown);
        } else {
            int sell = prices[day] + dfs(day + 2, 1, prices);
            int cooldown = dfs(day + 1, 0, prices);
            memo[day][buying] = Math.max(sell, cooldown);
        }

        return memo[day][buying];
    }
}
