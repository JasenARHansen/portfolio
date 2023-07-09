package Java.Code.Educative;
import java.util.ArrayList;
import java.util.List;

public class TreesLowestCommonAncestorOfABinarySearchTree {
  /*
  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

  Example 1:
             6
          /     \
        2         8
      /   \     /   \
    0      4   7     9
          / \
         3   5
  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
  Output: 6
  Explanation: The LCA of nodes 2 and 8 is 6.

  Example 2:
             6
          /     \
        2         8
      /   \     /   \
    0      4   7     9
          / \
         3   5
  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
  Output: 2
  Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

  Example 3:
         2
        /
       1
  Input: root = [2,1], p = 2, q = 1
  Output: 2
  */

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> p_path = getPath(root, p);
    List<TreeNode> q_path = getPath(root, q);
    TreeNode return_node = null;
    while ((!p_path.isEmpty()) && (!q_path.isEmpty()) && (p_path.get(0) == q_path.get(0))) {
      return_node = p_path.remove(0);
      q_path.remove(0);
    }
    return return_node;
  }

  private static List<TreeNode> getPath(TreeNode root, TreeNode node) {
    List<TreeNode> returnList = new ArrayList<>();
    boolean notFound = true;
    TreeNode current = root;
    while (notFound) {
      if (node.data == current.data) {
        returnList.add(current);
        notFound = false;
      } else if ((node.data < current.data) && (current.left != null)) {
        returnList.add(current);
        current = current.left;
      } else if ((node.data > current.data) && (current.right != null)) {
        returnList.add(current);
        current = current.right;
      } else {
        returnList.clear();
        notFound = false;
      }
    }
    return returnList;
  }

  public static class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
