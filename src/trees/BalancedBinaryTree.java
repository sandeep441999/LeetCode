package trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return dfs(root) != -1;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        if (left == -1)
            return -1;
        int right = dfs(node.right);

        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}
