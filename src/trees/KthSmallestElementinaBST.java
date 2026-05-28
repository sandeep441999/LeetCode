package trees;

public class KthSmallestElementinaBST {
    // List<Integer> res = new ArrayList<>();
    int count = 0;
    TreeNode res;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        // return res.get(k-1);
        return res.val;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null)
            return;

        dfs(node.left, k);
        count++;
        if (count == k) {
            res = node;
            return;
        }
        // res.add(node.val);
        dfs(node.right, k);

    }
}
