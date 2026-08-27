package dp;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        // HashMap<String, Integer> dp = new HashMap<>();
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        return dfs(1, n, arr, dp);
    }

    // public int dfs(int l, int r, int[] arr, HashMap<String, Integer> dp) {
    public int dfs(int l, int r, int[] arr, int[][] dp) {
        if (l > r)
            return 0;

        // String key = l + "-" + r;

        // if(dp.containsKey(key)) return dp.get(key);
        if (dp[l][r] != 0)
            return dp[l][r];
        int maxCoins = 0;

        for (int i = l; i < r + 1; i++) {
            int coins = arr[l - 1] * arr[i] * arr[r + 1];
            coins += dfs(l, i - 1, arr, dp) + dfs(i + 1, r, arr, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        // dp.put(key, maxCoins);
        dp[l][r] = maxCoins;
        return maxCoins;
    }
}
