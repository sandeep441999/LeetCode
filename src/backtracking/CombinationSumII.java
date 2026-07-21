package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, ArrayList<Integer> cur, int curSum, int start) {
        if (curSum == target) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (curSum + candidates[i] <= target) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                cur.add(candidates[i]);
                dfs(candidates, target, cur, curSum + candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }

        }
    }
}
