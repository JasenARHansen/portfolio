package Java.Code.Educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphsCloneADirectedGraph {
  /*
  Given the root node of a directed graph, clone this graph by creating its deep copy so that the cloned graph has
   the same vertices and edges as the original graph.

  Let’s look at the below graphs as an example. If the input graph is G = (V, E) where V is set of vertices and E
   is set of edges, then the output graph (cloned graph) G’ = (V’, E’) such that V = V’ and E = E’.
   0: 3, 4
   1: 2
   2: 0
   3: 2
   4: 1, 3
  We use depth-first traversal and create a copy of each node while traversing the graph. To avoid getting stuck in
   cycles, we’ll use a hashtable to store each completed node and will not revisit nodes that exist in the hashtable.

  The hashtable key will be a node in the original graph, and its value will be the corresponding node in the
   cloned graph.

  */

    public static Node clone(Node root) {
        Map<Node, Node> map = new HashMap<>();
        _clone(root, map);
        return map.get(root);
    }

    private static void _clone(Node node, Map<Node, Node> map) {
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.data));
            for (Node neighbor : node.neighbors) {
                _clone(neighbor, map);
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }

    }

    public static class Node {
        public int data;
        public List<Node> neighbors;

        public Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }
    }
}
