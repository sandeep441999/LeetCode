package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> cur) {
        res.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            dfs(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
