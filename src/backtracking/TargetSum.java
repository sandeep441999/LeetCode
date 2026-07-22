package backtracking;

import java.util.HashMap;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return dfs(nums, target, 0, 0, map);
    }

    public int dfs(int[] nums, int target, int cur, int start, HashMap<String, Integer> map) {
        if (start == nums.length) {
            return cur == target ? 1 : 0;
        }

        String key = start + "," + cur;

        if (map.containsKey(key))
            return map.get(key);

        int count = dfs(nums, target, cur + nums[start], start + 1, map)
                + dfs(nums, target, cur - nums[start], start + 1, map);
        map.put(key, count);

        return count;

    }
}
