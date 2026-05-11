package trees;

import java.util.HashMap;

public class ConstructBinaryTreeromPreorderandInorderTraversal {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int pstart, int pend, int istart, int iend) {
        if (pstart > pend || istart > iend)
            return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int mid = map.get(preorder[pstart]);
        int leftSize = mid - istart;

        root.left = dfs(preorder, pstart + 1, pstart + leftSize, istart, mid - 1);
        root.right = dfs(preorder, pstart + leftSize + 1, pend, mid + 1, iend);
        return root;
    }
}
