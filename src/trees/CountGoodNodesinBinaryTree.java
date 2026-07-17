package trees;

public class CountGoodNodesinBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null)
            return 0;
        int count = 0;
        if (max <= root.val) {
            count += 1;
            max = root.val;
        }
        count += dfs(root.left, max);
        count += dfs(root.right, max);
        return count;
    }
}
