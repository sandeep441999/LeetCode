package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1)
                    res.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

        }

        return res;

    }
}
