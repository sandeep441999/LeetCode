package dp;

import java.util.HashMap;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        int n = stones.length;
        // int[][] memo = new int[n][n+1];
        // for(int[] x : memo) {
        // Arrays.fill(x, -1);
        // }
        // return f(stones, 1, 1, memo);

        boolean[][] dp = new boolean[n][n + 1];
        for (int k = 0; k <= n; k++) {
            dp[n - 1][k] = true;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        for (int i = n - 2; i >= 1; i--) {
            for (int k = 1; k <= n; k++) {
                for (int j = -1; j <= 1; j++) {
                    int jump = k + j;
                    if (jump <= 0 || jump > n)
                        continue;
                    int nextStep = stones[i] + jump;
                    Integer idx = map.get(nextStep);
                    if (idx != null) {
                        if (dp[idx][jump]) {
                            dp[i][k] = true;
                        }
                    }
                }
            }
        }
        return dp[1][1];
    }

    public boolean f(int[] stones, int i, int k, int[][] memo) {
        int n = stones.length;
        if (i >= n)
            return false;
        if (i == n - 1) {
            return true;
        }

        if (memo[i][k] != -1)
            return memo[i][k] == 1;

        for (int j = -1; j <= 1; j++) {
            int jump = k + j;
            if (jump <= 0)
                continue;
            int nextStep = stones[i] + jump;
            int idx = -1;
            for (int x = i + 1; x < n; x++) {
                if (stones[x] == nextStep) {
                    idx = x;
                    break;
                }
            }
            if (idx != -1) {
                if (f(stones, idx, jump, memo)) {
                    memo[i][k] = 1;
                    return true;
                }
            }
        }
        memo[i][k] = 0;

        return false;
    }
}
