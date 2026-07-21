package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited);
        return res;
    }

    public void dfs(int[] nums, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, cur, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }

        }
    }
}
