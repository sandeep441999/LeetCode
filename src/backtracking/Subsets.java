package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> cur) {

        res.add(new ArrayList(cur));

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i + 1, cur);
            cur.remove(cur.size() - 1);

        }
    }
}
