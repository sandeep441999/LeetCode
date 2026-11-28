package dp;

import java.util.HashMap;

public class TargetSum {
    record State(int i, int t) {
    };

    public int findTargetSumWays(int[] nums, int target) {
        // HashMap<State, Integer> map = new HashMap<>();
        int n = nums.length;
        // int[][] dp = new int[n][2001];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return f(n-1, target, nums, dp);
        // return f(n-1, target, nums, map);

        // now we are finding it hard to do the tabulation with below 2 function we can
        // treat this problem as count 2 subset whose difference is target

        int total = 0;
        for (int x : nums) {
            total += x;
        }
        // int[][] dp = new int[n][total+1];
        // for(int i=0; i<n; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        int[][] dp = new int[n + 1][total + 1];
        for (int cur = 0; cur <= total; cur++) {
            int s1 = cur;

            int val = total - 2 * s1;

            dp[0][cur] = (val == target) ? 1 : 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int cur = 0; cur <= total; cur++) {
                int pick = 0;
                if (cur + nums[i - 1] <= total) {
                    pick = dp[i - 1][cur + nums[i - 1]];
                }
                int notPick = dp[i - 1][cur];
                dp[i][cur] = pick + notPick;
            }
        }

        return dp[n][0];

        // return f(n-1, 0, total, target, nums, dp);
    }

    public int f(int i, int cur, int total, int target, int[] nums, int[][] dp) {

        if (i < 0) {
            int s1 = cur;

            int val = total - 2 * s1;

            return val == target ? 1 : 0;
        }

        if (dp[i][cur] != -1) {
            return dp[i][cur];
        }

        int pick = 0;
        if (cur + nums[i] <= total) {
            pick = f(i - 1, cur + nums[i], total, target, nums, dp);
        }
        int notPick = f(i - 1, cur, total, target, nums, dp);
        return dp[i][cur] = pick + notPick;
    }

    public int f(int i, int t, int[] nums, int[][] dp) {
        int offset = 1000;
        if (i < 0) {
            if (t == 0)
                return 1;
            return 0;
        }
        int idx = t + offset;
        if (t < -offset || t > offset)
            return 0;

        if (dp[i][idx] != -1)
            return dp[i][idx];

        int plus = f(i - 1, t - nums[i], nums, dp);
        int minus = f(i - 1, t + nums[i], nums, dp);

        return dp[i][idx] = plus + minus;
    }

    public int f(int i, int t, int[] nums, HashMap<State, Integer> map) {

        if (i < 0) {
            if (t == 0)
                return 1;
            return 0;
        }
        State state = new State(i, t);
        if (map.containsKey(state))
            return map.get(state);
        int plus = f(i - 1, t - nums[i], nums, map);
        int minus = f(i - 1, t + nums[i], nums, map);

        map.put(state, plus + minus);
        return plus + minus;
    }
}
