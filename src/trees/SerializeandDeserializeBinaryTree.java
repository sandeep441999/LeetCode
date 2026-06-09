package trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // if(root == null) return "[]";

        // Deque<TreeNode> q = new ArrayDeque<>();
        // q.offer(root);
        // // String res="[";
        // String res2 = "";
        // StringBuilder res = new StringBuilder();
        // res.append("[");

        // while(!q.isEmpty()) {
        // TreeNode node = q.poll();
        // int val = node.val;
        // if(val == 1001) {
        // // res+="null,";
        // res.append("null,");
        // continue;
        // }

        // // res+=val +",";
        // res.append(val).append(",");

        // if(node.left != null) {
        // q.offer(node.left);
        // } else {
        // q.offer(new TreeNode(1001));
        // // res+="null,";
        // }
        // if(node.right != null) {
        // q.offer(node.right);
        // } else {
        // q.offer(new TreeNode(1001));
        // // res+="null,";
        // }
        // }
        // res2 = res.toString();
        // res2 = res2.substring(0, res2.length()-1) + "]";
        // return res2;
        StringBuilder str = new StringBuilder();
        dfsSerialize(root, str);
        return str.toString().substring(0, str.length() - 1);
    }

    public void dfsSerialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        dfsSerialize(root.left, str);
        dfsSerialize(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // if(data.equals("[]")) return null;
        // data = data.substring(1, data.length()-1);
        // String[] nodes = data.split(",");
        // TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // Deque<TreeNode> q = new ArrayDeque<>();
        // q.offer(root);
        // int i=1;

        // while(!q.isEmpty() && i< nodes.length) {
        // TreeNode cur = q.poll();
        // if(!nodes[i].equals("null")) {
        // cur.left = new TreeNode(Integer.parseInt(nodes[i]));
        // q.offer(cur.left);
        // }
        // i++;
        // if(i<nodes.length && !nodes[i].equals("null")) {
        // cur.right = new TreeNode(Integer.parseInt(nodes[i]));
        // q.offer(cur.right);
        // }
        // i++;
        // }

        // return root;
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));

        return dfsDeserialize(q);

    }

    public TreeNode dfsDeserialize(Deque<String> q) {
        String val = q.poll();
        if (val.equals("#"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsDeserialize(q);
        node.right = dfsDeserialize(q);
        return node;
    }
}
