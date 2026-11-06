package dp;

public class PaintingtheWalls {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        // HashMap<String, Integer> map = new HashMap<>();
        // int[][] dp = new int[n][n+1];
        // for(int[] x : dp) {
        // Arrays.fill(x, -1);
        // }
        // return f1(n-1, cost.length, cost, time, dp);

        // int[][] dp = new int[n+1][n+1];

        int[] prev = new int[n + 1];

        // for(int j=1; j<=n; j++) {
        // dp[0][j] = Integer.MAX_VALUE/2;
        // }
        for (int j = 1; j <= n; j++) {
            prev[j] = Integer.MAX_VALUE / 2;
        }

        for (int idx = 1; idx <= n; idx++) {
            int[] cur = new int[n + 1];
            for (int remaining = 1; remaining <= n; remaining++) {
                int freeCost = 0 + prev[remaining];
                int nextRemaining = Math.max(0, remaining - 1 - time[idx - 1]);
                int paidCost = cost[idx - 1] + prev[nextRemaining];

                cur[remaining] = Math.min(freeCost, paidCost);
            }
            prev = cur;
        }

        // for(int idx=1; idx<=n; idx++) {
        // for(int remaining=1; remaining<=n; remaining++) {
        // int freeCost = 0 + dp[idx-1][remaining];
        // int nextRemaining =
        // Math.max(0, remaining - 1 - time[idx - 1]);
        // int paidCost = cost[idx-1] + dp[idx-1][nextRemaining];

        // dp[idx][remaining] = Math.min(freeCost, paidCost);
        // }
        // }

        // return dp[n][n];
        return prev[n];

    }
    // public int f1(int idx, int remaining, int[] cost, int[] time, int[][] dp) {
    // if(remaining <= 0) return 0;
    // if(idx<0) {
    // return Integer.MAX_VALUE/2;
    // }
    // if(dp[idx][remaining] != -1) return dp[idx][remaining];

    // int freeCost = 0 + f1(idx-1, remaining, cost, time, dp);
    // int paidCost = cost[idx] + f1(idx-1, remaining - 1 - time[idx], cost, time,
    // dp);

    // return dp[idx][remaining] = Math.min(freeCost, paidCost);
    // }

    // public int f(int idx, int freeTime, int paidTime, int[] cost, int[] time,
    // HashMap<String, Integer> map) {
    // if(idx<0) {
    // if(freeTime>paidTime) return (int) 10e7;
    // else return 0;
    // }
    // String key = idx + " " + freeTime + " " + paidTime;
    // if(map.containsKey(key)) return map.get(key);
    // // if(dp[idx][freeTime][paidTime] != -1) return dp[idx][freeTime][paidTime];

    // int freeCost = 0 + f(idx-1, freeTime+1, paidTime, cost, time, map);
    // int paidCost = cost[idx] + f(idx-1, freeTime, paidTime + time[idx], cost,
    // time, map);

    // // return dp[idx][freeTime][paidTime] = Math.min(freeCost, paidCost);
    // map.put(key, Math.min(freeCost, paidCost));
    // return map.get(key);
    // }
}
