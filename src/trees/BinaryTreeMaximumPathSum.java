package trees;

public class BinaryTreeMaximumPathSum {
    int res = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);
        res = Math.max(res, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
