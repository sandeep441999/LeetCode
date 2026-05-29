package trees;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TreeNode node = root;
        // while(node != null) {
        // if(node.val > p.val && node.val > q.val) {
        // node = node.left;
        // } else if(node.val < q.val && node.val < p.val) {
        // node = node.right;
        // } else {
        // return node;
        // }
        // }
        // return root;
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node.val > p.val && node.val > q.val) {
            return dfs(node.left, p, q);
        } else if (node.val < q.val && node.val < p.val) {
            return dfs(node.right, p, q);
        }

        return node;

    }
}
