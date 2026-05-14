package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> curr = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, targetSum, 0, curr);

        return res;
    }

    public void dfs(TreeNode root, int targetSum, int sum, List<Integer> curr) {
        if (root == null)
            return;
        sum += root.val;
        curr.add(root.val);
        if (sum == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(curr));
        }
        dfs(root.left, targetSum, sum, curr);
        dfs(root.right, targetSum, sum, curr);
        curr.remove(curr.size() - 1);
    }
}
