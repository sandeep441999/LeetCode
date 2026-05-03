package graphs;

import java.util.HashMap;
import java.util.Map;
import Node;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        return dfs(map, node);
        // Queue<Node> q = new LinkedList<>();

        // q.offer(node);
        // map.put(node, new Node(node.val));

        // while(!q.isEmpty()) {
        // Node cur = q.poll();

        // for(Node n : cur.neighbors) {
        // if(!map.containsKey(n)) {
        // map.put(n, new Node(n.val));
        // q.offer(n);
        // }
        // map.get(cur).neighbors.add(map.get(n));
        // }
        // }

        // return map.get(node);
    }

    public Node dfs(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(map, n));
        }

        return copy;
    }
}
