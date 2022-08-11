package Code.Educative;

import java.util.LinkedList;
import java.util.Queue;

public class TreesLevelOrderTraversalOfBinaryTree {
  /*
  Given the root of a binary tree, display the node values at each level. Node values for all levels should be
   displayed on separate lines. Let’s take a look at the below binary tree.

  Consider this tree
       		  100
           /       \
  		50 	    	200
      /    \           \
    25     75          350

  Level order traversal for this tree should look like:
    100
    50, 200
    25, 75, 35

  Runtime complexity: Linear, O(n)
  Here, you are using two queues: current_queue and next_queue. You push the nodes in both queues alternately based
   on the current level number. You’ll dequeue nodes from the current_queue, print the node’s data, and enqueue the
   node’s children to the next_queue.

  Once the current_queue becomes empty, you have processed all nodes for the current level_number. To indicate the
   new level, print a line break (\n), swap the two queues, and continue with the above-mentioned logic.

  After printing the leaf nodes from the current_queue, swap current_queue and next_queue. Since the current_queue
   would be empty, you can terminate the loop.
  */

  public static String level_order_traversal(Node node) {
    StringBuilder sb = new StringBuilder();
    Queue<Node> current = new LinkedList<>();
    Queue<Node> next;
    current.add(node);
    int level = 0;
    boolean afterFirst;
    while (!current.isEmpty()) {
      afterFirst = false;
      level++;
      sb.append("\n\t\tLevel ").append(level).append(":\t");
      next = new LinkedList<>();
      while (!current.isEmpty()) {
        if (afterFirst) {
          sb.append(", ");
        } else {
          afterFirst = true;
        }
        sb.append(current.peek().data);
        if (current.peek().left != null) {
          next.add(current.peek().left);
        }
        if (current.peek().right != null) {
          next.add(current.peek().right);
        }
        current.remove();
      }
      current = next;
    }
    return sb.toString();
  }

  public static class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
