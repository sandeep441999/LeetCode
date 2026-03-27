package arrays;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0, new ArrayList<>(), 0, target, candidates);

        return res;
    }

    public void dfs(int start, List<Integer> curr, int total, int target, int[] candidates) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (total + candidates[i] > target)
                continue;
            total += candidates[i];
            curr.add(candidates[i]);

            dfs(i, curr, total, target, candidates);

            total -= candidates[i];
            curr.remove(curr.size() - 1);

        }
    }
}
