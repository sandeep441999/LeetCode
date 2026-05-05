package graphs;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(0, 0, m - 1, n - 1, map);
    }

    public int dfs(int m, int n, int tm, int tn, Map<String, Integer> map) {
        if (m == tm && n == tn) {
            return 1;
        }
        if (m > tm || n > tn) {
            return 0;
        }
        String Key = m + "," + n;
        if (map.containsKey(Key)) {
            return map.get(Key);
        }
        int ways = dfs(m + 1, n, tm, tn, map) + dfs(m, n + 1, tm, tn, map);
        map.put(Key, ways);
        return ways;
    }
}
