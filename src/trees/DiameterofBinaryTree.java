package trees;

public class DiameterofBinaryTree {
    int res = 0;
    int lm = 0;
    int rm = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null && (root.left == null && root.right == null))
            return 0;
        // if(root != null && (root.left == null || root.right == null)) return 1;
        dfs(root);
        // return lm +rm;
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);
        // lm = Math.max(lm, left);
        // rm = Math.max(rm, right);

        return 1 + Math.max(left, right);
    }

}
