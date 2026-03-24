package trees;

import java.util.Queue;
import java.util.ArrayDeque;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        // if(root == null) {
        // return root;
        // }

        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        // invertTree(root.left);
        // invertTree(root.right);

        // return root;

        if (root == null)
            return root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        return root;

    }

}
