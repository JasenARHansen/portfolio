package Java.code.educative;

import java.util.ArrayList;
import java.util.List;

public class TreesConvertBinaryTreeToDoublyLinkedList {
  /*
  Convert a binary tree to a doubly linked list so that the order of the doubly linked list is the same as an in-order
   traversal of the binary tree.

  After conversion, the left pointer of the node should be pointing to the previous node in the doubly linked list,
   and the right pointer should be pointing to the next node in the doubly linked list. Try it yourself before
   reviewing the solution and explanation.

  Consider this tree
       		  100
           /       \
  		50 	    	200
      /    \       /   \
    25     75    125   350
      \    /
      30  60


  Runtime complexity: Linear, O(n)
  Memory Complexity: Linear, O(h)
  Recursive solution has O(h) memory complexity as it will consume memory on the stack up to the height of
   binary tree h. It will be O(logN) for balanced trees and in the worst case can be O(n).

  In an in-order traversal, first the left subtree is traversed, then the root is visited, and finally the
   right subtree is traversed.

  One simple way of solving this problem is to start with an empty doubly linked list. While doing the in-order
   traversal of the binary tree, keep inserting each element output into the doubly linked list.

  But, if we look at the question carefully, the interviewer wants us to convert the binary tree to a doubly
   linked list in-place i.e. we should not create new nodes for the doubly linked list.

  This problem can be solved recursively using a divide and conquer approach. Below is the algorithm specified.
    Start with the root node and solve left and right subtrees recursively
    At each step, once left and right subtrees have been processed:
    Fuse output of left subtree with root to make the intermediate result
    Fuse intermediate result (built in the previous step) with output from the right subtree to make the final
     result of the current recursive call.
  */

  public static List<Node> convert_to_linked_list(Node node) {
    List<Node> returnList = new ArrayList<>();
    _convert_to_linked_list(returnList, node);
    return returnList;
  }

  public static void _convert_to_linked_list(List<Node> returnList, Node node) {
    // Left path
    if (node.left != null) {
      _convert_to_linked_list(returnList, node.left);
    }
    // Current
    if (!returnList.isEmpty()) {
      returnList.get(returnList.size() - 1).right = node;
      node.left = returnList.get(returnList.size() - 1);
    }
    returnList.add(node);
    // Right path
    if (node.right != null) {
      _convert_to_linked_list(returnList, node.right);
    }
  }

  public static class Node {
    public final int data;
    public Node left;
    public Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
